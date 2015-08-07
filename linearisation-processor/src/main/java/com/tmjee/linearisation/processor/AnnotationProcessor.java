package com.tmjee.linearisation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.StandardLocation;
import java.util.Collections;
import java.util.Set;

/**
 * @author tmjee
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (TypeElement annotation : annotations) {
                System.out.println("********** From AnnotationProcessor @"+annotation.getSimpleName() + System.currentTimeMillis());
                System.out.println(annotation.getAnnotation(Invariant.class));
                System.out.println(annotation.getAnnotation(Player.class));
                System.out.println(StandardLocation.SOURCE_OUTPUT);
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
}
