package org.rapidpm.module.se.commons.proxy.builder;


import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import org.rapidpm.module.se.commons.proxy.type.metrics.MetricsRegistry;
import org.rapidpm.module.se.commons.proxy.type.virtual.Concurrency;
import org.rapidpm.module.se.commons.proxy.type.virtual.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sven on 28.04.15.
 */
public class ProxyBuilder<I, T extends I> {

  private T original;
  private Class<I> clazz;

  private ProxyBuilder() {
  }

  public static <I, T extends I> ProxyBuilder<I, T> createBuilder(Class<I> clazz, T original) {
    final ProxyBuilder<I, T> proxyBuilder = new ProxyBuilder<>();
    proxyBuilder.original = original;
    proxyBuilder.clazz = clazz;
    return proxyBuilder;
  }

  public static <I, T extends I> ProxyBuilder<I, T> createBuilder(Class<I> clazz, Class<T> original, Concurrency concurrency) {
    final ProxyBuilder<I, T> proxyBuilder = new ProxyBuilder<>();
    final I proxy = ProxyGenerator.make(clazz, original, concurrency);
    proxyBuilder.original = (T)proxy;
    proxyBuilder.clazz = clazz;
    return proxyBuilder;
  }





  //die originalReihenfolge behalten in der die Methoden aufgerufen worden sind.
  public I build() {
    Collections.reverse(securityRules);
    securityRules.forEach(this::build_addSecurityRule);
    return this.original;
  }

  private List<SecurityRule> securityRules = new ArrayList<>();

  public ProxyBuilder<I, T> addSecurityRule(SecurityRule rule) {
    securityRules.add(rule);
    return this;
  }

  private ProxyBuilder<I, T> build_addSecurityRule(SecurityRule rule) {
    final ClassLoader classLoader = original.getClass().getClassLoader();
    final Class<?>[] interfaces = {clazz};
    final Object nextProxy = Proxy.newProxyInstance(
        classLoader,
        interfaces,
        new InvocationHandler() {
          private T original = ProxyBuilder.this.original;
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            final boolean checkRule = rule.checkRule();
            if (checkRule) {
              return method.invoke(original, args);
            } else {
              return null;
            }
          }
        });
    original = (T) clazz.cast(nextProxy);
    return this;
  }



  //wo die Metriken ablegen ?
  public ProxyBuilder<I, T> addMetrics() {
    final MetricRegistry metrics = MetricsRegistry.getInstance().getMetrics();
    final ClassLoader classLoader = original.getClass().getClassLoader();
    final Class<?>[] interfaces = {clazz};
    final Object nextProxy = Proxy.newProxyInstance(
        classLoader,
        interfaces,
        new InvocationHandler() {
          private final Histogram methodCalls = metrics.histogram(clazz.getSimpleName());
          private final T original = ProxyBuilder.this.original;

          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            System.out.println("addMetrics = is running");
            final long start = System.nanoTime();
            final Object invoke = method.invoke(original, args);
            final long stop = System.nanoTime();
            methodCalls.update((stop - start));
            return invoke;
          }
        });
    original = (T) clazz.cast(nextProxy);
    return this;
  }



  public ProxyBuilder<I, T> addLogging() {
    return this;
  }


}
