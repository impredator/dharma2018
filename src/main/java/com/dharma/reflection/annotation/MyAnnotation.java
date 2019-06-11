package com.dharma.reflection.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE})
public @interface MyAnnotation {
    String name();
    String value();
}
