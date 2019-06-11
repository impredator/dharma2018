package com.dharma.reflection.annotation;

@MyAnnotation(name="className",  value = "classValue")
public class TheClass {
    @MyAnnotation(name="fieldName",  value = "fieldValue")
    public String myField = null;

    @MyAnnotation(name="methodName",  value = "methodValue")
    public void doSomething(){}

    public static void doSomethingElse(
            @MyAnnotation(name="paramName", value="paramValue") String parameter){
    }
}
