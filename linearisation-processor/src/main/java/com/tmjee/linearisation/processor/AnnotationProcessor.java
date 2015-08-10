package com.tmjee.linearisation.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.StandardLocation;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        if (!roundEnv.processingOver()) {
            System.out.println("**** start processing");

            Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(Linearisable.class);
            for (Element e : set) {
                Test test = parse(e);
            }


        } else {
            System.out.println("**** processing over");
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Linearisable.class.getName());
    }

    private Test parse(Element e) {
        System.out.println("=== "+e);

        Linearisable linearisableAnnotation = e.getAnnotation(Linearisable.class);
        Consequences consequencesAnnotation = e.getAnnotation(Consequences.class);
        References referencesAnnotation = e.getAnnotation(References.class);

        System.out.println("Linearisable annotation="+linearisableAnnotation);
        System.out.println("Consequences annotation="+consequencesAnnotation);
        System.out.println("References annotation="+referencesAnnotation);

        List<? extends Element> list = e.getEnclosedElements();
        for (Element e1 : list) {
            if (e1.getKind() == ElementKind.CLASS) {
                System.out.println("inner class="+e1);
            }
            if (e1.getKind() == ElementKind.METHOD) {
                System.out.println("method enclosing element="+e1.getEnclosingElement());
                System.out.println("method ="+e1);
            }
        }

        return null;
    }
}
