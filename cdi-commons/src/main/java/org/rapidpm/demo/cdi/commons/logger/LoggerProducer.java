package org.rapidpm.demo.cdi.commons.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;

import org.rapidpm.demo.cdi.commons.registry.ContextResolver;


/**
 * User: Sven Ruppert
 * Date: 03.06.13
 * Time: 09:04
 */
public class LoggerProducer {

    /**
     * @param injectionPoint
     * @return logger
     */
    @Produces
    @CDILogger
    public Logger produceLog4JLogger(InjectionPoint injectionPoint, BeanManager beanManager, ContextResolver contextResolver) {
        final Class<?> declaringClass = injectionPoint.getMember().getDeclaringClass();
        return new Logger(declaringClass);
    }
}