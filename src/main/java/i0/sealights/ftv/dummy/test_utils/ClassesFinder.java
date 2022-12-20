package i0.sealights.ftv.dummy.test_utils;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassesFinder {
    public Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    private Boolean exclude(ClassPath.ClassInfo clazz, List<String> excludePatterns){
        if (excludePatterns == null)
            return false;
        if (excludePatterns.size() == 0)
            return false;
        for (String excludePattern : excludePatterns){
            if(clazz.getName().contains(excludePattern)){
                return true;
            }
        }
        return false;
    }

    private Boolean include(ClassPath.ClassInfo clazz, List<String> includePatterns){
        if (includePatterns == null)
            return true;
        if (includePatterns.size() == 0)
            return true;
        for (String includePattern : includePatterns){
            if(!clazz.getName().contains(includePattern)){
                return false;
            }
        }
        return true;
    }

    public Set<Class> findAllClassesUsingGoogleGuice(List<String> excludePatterns, List<String> includePatterns) throws IOException {

        ImmutableSet<ClassPath.ClassInfo> allClasses = ClassPath.from(URLClassLoader.getSystemClassLoader()).getAllClasses();

        Stream<ClassPath.ClassInfo> filtered = allClasses
                .stream()
                .filter(clazz -> (
                                !clazz.getPackageName().contains("target") &&
                                        !clazz.getName().contains("Interface") &&
                                        !clazz.getName().contains("Test") &&
                                        include(clazz, includePatterns) &&
                                        !exclude(clazz, excludePatterns)
                        )
                );

        Set<Class> f = filtered
                .map(clazz -> clazz.load())
                .collect(Collectors.toSet());
        return f;
    }

}
