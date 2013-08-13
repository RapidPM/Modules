package org.rapidpm.demo.cdi.commons.registry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * User: Sven Ruppert
 * Date: 20.06.13
 * Time: 08:43
 */
@Qualifier
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface CDIRessourceKey {
    @Nonbinding String value() default "";
    Class<?> clazz();
}
