package com.tmjee.linearisation.processor;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.util.*;

/**
 * @author tmjee
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {

    private static final String GENERATED_RUNNER_PACKAGE_NAME = "linearisation.generated";

    private Elements elements;
    private Types types;
    private Filer filer;
    private Messager messager;
    private Configuration configuration;

    private List<Test> tests;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        elements = processingEnv.getElementUtils();
        types = processingEnv.getTypeUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();

        tests = new ArrayList<>();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {

            Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Linearisable.class);
            for (Element e : set) {
                List<Test> t = parse(e);
                validate(t);
                generateSource(t);
                tests.addAll(t);
            }

        } else {
            generateMetaFile(tests);
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Linearisable.class.getName());
    }


    private void initConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setTemplateLoader(new ClassTemplateLoader(AnnotationProcessor.class, "/template"));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
    }

    private void validate(List<Test> tests) {
        // todo:
    }

    private void generateSource(List<Test> tests) {
        try {
            initConfiguration();
            Template template = configuration.getTemplate("runner_java.ftl");

            for (Test test : tests) {

                messager.printMessage(Diagnostic.Kind.NOTE, "**** testing ");

                // create model for templating
                Map<String, Object> model = new HashMap<>();
                model.put("test", test);

                Test.ClassInfo runner = test.runner();
                try (Writer writer = filer.createSourceFile(runner.packageName + "." + runner.className).openWriter()) {
                    template.process(model, new OutputStreamWriter(System.out));
                    template.process(model, writer);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


    private void generateMetaFile(List<Test> tests) {
        try {
            initConfiguration();
            Template template = configuration.getTemplate("linearisation_tests_xml.ftl");

            Map<String, Object> model = new HashMap<>();
            model.put("tests", tests);

            try (Writer writer = filer.createResource(StandardLocation.CLASS_OUTPUT, "", Tests.TESTS_LOCATION.substring(1)).openWriter()) {
                template.process(model, new OutputStreamWriter(System.out));
                template.process(model, writer);
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


    private TypeElement findMetaAnnotationTargetTypeElement(Element e) {
        String metaClassName = Meta.class.getName();
        for (AnnotationMirror annotationMirror : e.getAnnotationMirrors()) {
            if (metaClassName.equals(annotationMirror.getAnnotationType().toString())) {
                for(Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
                    if ("value".equals(entry.getKey().getSimpleName().toString())) {
                        AnnotationValue v = entry.getValue();
                        String metaValueClassName = v.getValue().toString();
                        TypeElement typeElement = elements.getTypeElement(metaValueClassName);
                        return typeElement;
                    }
                }
            }
        }
        return null;
    }

    private Set<Consequence> _findConsequencesAnnotation(Element e) {
        Consequences consequencesAnnotation = e.getAnnotation(Consequences.class);
        if (consequencesAnnotation == null && e.getAnnotation(Consequence.class) != null) {
            return Collections.singleton(e.getAnnotation(Consequence.class));
        } else if (consequencesAnnotation == null) {
            return Collections.EMPTY_SET;
        }
        return new HashSet<>(Arrays.<Consequence>asList(consequencesAnnotation.value()));
    }


    private Consequences findConsequencesAnnotation(Element e) {
        Set<Consequence> consequencesFromMeta = Collections.EMPTY_SET;
        Set<Consequence> consequencesFromTestClass = Collections.EMPTY_SET;
        Meta meta = e.getAnnotation(Meta.class);
        if (meta != null) {
            TypeElement typeElement = findMetaAnnotationTargetTypeElement(e);
            if (typeElement != null) {
                consequencesFromMeta = _findConsequencesAnnotation(typeElement);
            }
        }
        consequencesFromTestClass = _findConsequencesAnnotation(e);
        final Set<Consequence> consequencesSet = new TreeSet<>((c1,c2)->c1.id().equals(c2.id()) ? 0 : (c1.id().compareTo(c2.id())));
        consequencesSet.addAll(consequencesFromMeta);
        consequencesSet.addAll(consequencesFromTestClass);
        return new Consequences() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Consequences.class;
            }

            @Override
            public Consequence[] value() {
                return consequencesSet.toArray(new Consequence[0]);
            }
        };
    }

    private Set<Reference> _findReferencesAnnotation(Element e) {
        References referencesAnnotation = e.getAnnotation(References.class);
        if (referencesAnnotation == null && e.getAnnotation(Reference.class) != null) {
            return Collections.singleton(e.getAnnotation(Reference.class));
        } else if (referencesAnnotation == null) {
            return Collections.EMPTY_SET;
        }
        return new HashSet<>(Arrays.<Reference>asList(referencesAnnotation.value()));
    }

    private References findReferencesAnnotation(Element e) {
        Set<Reference> referencesFromMeta = Collections.EMPTY_SET;
        Set<Reference> referencesFromTestClass = Collections.EMPTY_SET;
        Meta meta = e.getAnnotation(Meta.class);
        if (meta != null) {
            TypeElement typeElement = findMetaAnnotationTargetTypeElement(e);
            if (typeElement != null) {
                referencesFromMeta = _findReferencesAnnotation(typeElement);
            }
        }
        referencesFromTestClass = _findReferencesAnnotation(e);
        final Set<Reference> referencesSet = new HashSet<>(referencesFromMeta);
        referencesSet.addAll(referencesFromTestClass);
        return new References(){

            @Override
            public Class<? extends Annotation> annotationType() {
                return References.class;
            }

            @Override
            public Reference[] value() {
                return referencesSet.toArray(new Reference[0]);
            }
        };
    }

    private List<Test> parse(Element e) {


        List<Test> tests = new ArrayList<>();

        List<? extends Element> list = e.getEnclosedElements();
        for (Element e1 : list) {
            TestUnit testUnitAnnotation = e1.getAnnotation(TestUnit.class);
            if (e1.getKind() == ElementKind.CLASS && testUnitAnnotation != null) {

                Test.Builder builder = new Test.Builder();

                String testUnitName = testUnitAnnotation.name();
                String testUnitDescription = testUnitAnnotation.description();
                String testPackageName = getPackageName((TypeElement) e1);
                String testClassName = getClassName((TypeElement) e1);
                String runnerPackageName =  GENERATED_RUNNER_PACKAGE_NAME;
                String runnerClassName = buildRunnerClassName((TypeElement) e1);

                Consequences consequencesAnnotation = findConsequencesAnnotation(e);
                if (consequencesAnnotation != null) {
                    for (Consequence consequence : consequencesAnnotation.value()) {
                        builder.addConsequence(consequence.id(), consequence.expectation(), consequence.description());
                    }
                }

                References referencesAnnotation = findReferencesAnnotation(e);
                if (referencesAnnotation != null) {
                    for (Reference reference : referencesAnnotation.value()) {
                        builder.addReference(reference.value());
                    }
                }

                builder.withName(testUnitName)
                        .withDescription(testUnitDescription)
                        .withRunner(runnerPackageName, runnerClassName)
                        .withTestClass(testPackageName, testClassName);


                for (Element e2 : e1.getEnclosedElements()) {
                    if (e2.getKind() == ElementKind.METHOD) {
                        boolean isPlayer = (e2.getAnnotation(Player.class) != null);
                        boolean isArbiter = (e2.getAnnotation(Arbiter.class) != null);
                        if (isPlayer || isArbiter) {
                            List<String> args = new ArrayList<>(2);
                            List<? extends VariableElement> e3s = ((ExecutableElement) e2).getParameters();
                            if (e3s.size() <= 2) {
                                for (Element e3 : e3s) {
                                    TypeElement paramElement = (TypeElement) types.asElement(e3.asType());
                                    if (paramElement.getAnnotation(Invariant.class) != null) {
                                        builder.withInvariant(getPackageName(paramElement), getClassName(paramElement));
                                        args.add("invariant");
                                    }
                                    if (paramElement.getAnnotation(Record.class) != null) {
                                        builder.withRecord(getPackageName(paramElement), getClassName(paramElement));
                                        args.add("record");
                                    }
                                }
                            }

                            if (isPlayer) {
                                builder.addTestMethod(
                                        getMethodName((ExecutableElement) e2), args.toArray(new String[0]));
                            } else if (isArbiter) {
                                builder.addArbiterMethod(
                                        getMethodName((ExecutableElement) e2), args.toArray(new String[0]));
                            }
                        }
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
