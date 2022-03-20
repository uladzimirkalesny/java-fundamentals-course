package com.bobocode.basics;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.bobocode.basics.Level.BASIC;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Exercise {
    /**
     * Contains exercise name.
     *
     * @return exercise name
     */
    String value();

    /**
     * Contains complexity level.
     *
     * @return complexity level
     */
    Level complexityLevel() default BASIC;
}
