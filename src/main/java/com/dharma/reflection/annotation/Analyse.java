package com.dharma.reflection.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Analyse {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        AnnotationClass();

        annotationMethod();

        annotationParameter();

        annotationField();
    }

    private static void annotationField() throws NoSuchFieldException {
        Class aClass = TheClass.class;
        Field field = aClass.getField("myField");
        Annotation[] annotations = field.getDeclaredAnnotations();
        getAnnotations(annotations);

        Annotation annotation = field.getAnnotation(MyAnnotation.class);
        getAnnotation(annotation);
    }

    private static void annotationParameter() throws NoSuchMethodException {
        Class aClass = TheClass.class;
        Method method = aClass.getMethod("doSomethingElse", String.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class[] parameterTypes = method.getParameterTypes();

        int i=0;
        for(Annotation[] annotations : parameterAnnotations){
            Class parameterType = parameterTypes[i++];

            for(Annotation annotation : annotations){
                if(annotation instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name : " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }
        }
    }

    private static void annotationMethod() throws NoSuchMethodException {
        Class aClass = TheClass.class;
        Method method = aClass.getMethod("doSomething");
        Annotation[] annotations = method.getDeclaredAnnotations();
        getAnnotations(annotations);

        Annotation annotation = method.getAnnotation(MyAnnotation.class);
        getAnnotation(annotation);
    }

    private static void AnnotationClass() {
        Class aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();
        getAnnotations(annotations);

        Class bClass = TheClass.class;
        Annotation annotation = bClass.getAnnotation(MyAnnotation.class);
        getAnnotation(annotation);
    }

    private static void getAnnotation(Annotation annotation) {
        if (annotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }

    private static void getAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            getAnnotation(annotation);
        }
    }
}
