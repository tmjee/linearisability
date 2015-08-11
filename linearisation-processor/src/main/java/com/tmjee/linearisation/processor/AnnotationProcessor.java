package com.tmjee.linearisation.processor;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * @author tmjee
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {

    private Elements elements;
    private Types types;
    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        elements = processingEnv.getElementUtils();
        types = processingEnv.getTypeUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        List<Test> tests = new ArrayList<>();
        if (!roundEnv.processingOver()) {
            System.out.println("**** start processing");

            Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Linearisable.class);
            for (Element e : set) {
                List<Test> t = parse(e);
                validate(t);
                generateSource(t);
                tests.addAll(t);
            }

        } else {
            System.out.println("**** processing over");
            generateMetaFile(tests);
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Linearisable.class.getName());
    }


    private void validate(List<Test> tests) {
        // todo:
    }

    private void generateSource(List<Test> tests) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setTemplateLoader(new ClassTemplateLoader(AnnotationProcessor.class, "/"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        try {
            Template template = configuration.getTemplate("runner_java.ftl");

            for (Test test : tests) {
                Test.ClassInfo runner = test.runner();
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("test", test);
                System.out.println("***** "+runner.packageName+"."+runner.className);
                try (Writer writer = filer.createSourceFile(runner.packageName + "." + runner.className).openWriter()) {
                    template.process(model, new OutputStreamWriter(System.out));
                    template.process(model, writer);
                    writer.flush();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


    private void generateMetaFile(List<Test> tests) {

    }

    private List<Test> parse(Element e) {
        System.out.println("=== "+e);

        Consequences consequencesAnnotation = e.getAnnotation(Consequences.class);
        References referencesAnnotation = e.getAnnotation(References.class);

        List<Test> tests = new ArrayList<>();

        List<? extends Element> list = e.getEnclosedElements();
        for (Element e1 : list) {
            TestUnit testUnitAnnotation = e1.getAnnotation(TestUnit.class);
            if (e1.getKind() == ElementKind.CLASS && testUnitAnnotation != null) {

                Test.Builder builder = new Test.Builder();

                String testUnitName = testUnitAnnotation.name();
                String testUnitDescription = testUnitAnnotation.description();
                String testPackageName = getPackageName((TypeElement)e1);
                String testClassName = getClassName((TypeElement)e1);
                String runnerPackageName = "linearisation.generated";
                String runnerClassName = buildRunnerClassName((TypeElement)e1);

                for (Consequence consequence : consequencesAnnotation.value()) {
                    builder.addConsequence(consequence.id(), consequence.expectation(), consequence.description());
                }

                for (Reference reference : referencesAnnotation.value()) {
                    builder.addReference(reference.value());
                }

                builder.withName(testUnitName)
                        .withDescription(testUnitDescription)
                        .withRunner(runnerPackageName, runnerClassName);


                for (Element e2 : e1.getEnclosedElements()) {
                    if (e2.getKind() == ElementKind.METHOD && e2.getAnnotation(Player.class) != null) {
                        System.out.println("\tplayer method="+e2.getSimpleName());
                        List<String> args = new ArrayList<>(2);
                        List<? extends VariableElement> e3s = ((ExecutableElement)e2).getParameters();
                        if (e3s.size() <= 2) {
                            for (Element e3 : e3s) {
                                TypeElement paramElement = (TypeElement)types.asElement(e3.asType());
                                if (paramElement.getAnnotation(Invariant.class) != null) {
                                    System.out.println("param invariant");
                                    builder.withInvariant(getClassName(paramElement), getPackageName(paramElement));
                                    args.add("invariant");
                                }
                                if (paramElement.getAnnotation(Record.class) != null) {
                                    System.out.println("param record");
                                    builder.withRecord(getPackageName(paramElement), getClassName(paramElement));
                                    args.add("record");
                                }
                            }
                        }

                        builder.addTest(
                                testPackageName,
                                testClassName,
                                getMethodName((ExecutableElement) e2), args.toArray(new String[0]));
                    }
                }

                Test test = builder.build();
                tests.add(test);
            }
        }

        return tests;
    }

    private String buildRunnerClassName(TypeElement typeElement) {

        boolean first = true;
        String name = "";
        Element p = typeElement;
        while(p.getKind() != ElementKind.PACKAGE) {
            if (first) {
                name = p.getSimpleName() + name;
                first = false;
            } else {
                name = p.getSimpleName() + "_" +  name;
            }
            p = p.getEnclosingElement();
        }
        return name + "_Runner";
    }

    private String getPackageName(TypeElement typeElement) {

        Element p = typeElement;
        while(p.getKind() != ElementKind.PACKAGE) {
            p = p.getEnclosingElement();
        }
        return ((PackageElement)p).getQualifiedName().toString();
    }

    private String getClassName(TypeElement typeElement) {

        boolean first = true;
        String name = "";
        Element p = typeElement;
        while(p.getKind() == ElementKind.CLASS) {
            if (first) {
                name = p.getSimpleName() + name;
                first = false;
            } else {
                name = p.getSimpleName() + "." + name;
            }
            p = p.getEnclosingElement();
        }
        return name;
    }

    private String getMethodName(ExecutableElement executableElement) {
        return executableElement.getSimpleName().toString();
    }

}
