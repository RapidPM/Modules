package org.rapidpm.demo.cdi.commons.fx;

import java.io.IOException;
import java.lang.Class;
import java.lang.ClassLoader;
import java.lang.ClassNotFoundException;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Sven Ruppert
 * Date: 08.07.13
 * Time: 16:40
 */
public class FXClassLoader extends ClassLoader {

    private final Map<String, Class> classes = new HashMap<String, Class>();
    private final ClassLoader parent;


    public FXClassLoader(ClassLoader parent) {
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> c = findClass(name);
        if (c == null) {
            throw new ClassNotFoundException(name);
        }
        return c;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        if (classes.containsKey(className)) {
            Class<?> result = classes.get(className);
            return result;
        } else {
            try {
                Class<?> result = parent.loadClass(className);
                classes.put(className, result);
                return result;
            } catch (ClassNotFoundException ignore) {
                classes.put(className, null);
                return null;
            }
        }
    }

    // ========= delegating methods =============
    @Override
    public URL getResource(String name) {
        return parent.getResource(name);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return parent.getResources(name);
    }

    @Override
    public String toString() {
        return parent.toString();
    }

    @Override
    public void setDefaultAssertionStatus(boolean enabled) {
        parent.setDefaultAssertionStatus(enabled);
    }

    @Override
    public void setPackageAssertionStatus(String packageName, boolean enabled) {
        parent.setPackageAssertionStatus(packageName, enabled);
    }

    @Override
    public void setClassAssertionStatus(String className, boolean enabled) {
        parent.setClassAssertionStatus(className, enabled);
    }

    @Override
    public void clearAssertionStatus() {
        parent.clearAssertionStatus();
    }
}