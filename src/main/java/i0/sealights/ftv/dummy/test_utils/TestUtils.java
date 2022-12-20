package i0.sealights.ftv.dummy.test_utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestUtils {
    public static final String DATA_GEN = "data_gen";
    public static final String DATA_RET = "data_ret";
    public static final String GENERATE_DATA = "generateData";
    public static final String RETRIEVE_DATA = "retrieveData";
    public static final String CLEAR_INVOKED = "clearInvoked";
    public static final String UNKNOWN = "unknown";



    public static TestData getTestData(){
        try {
            InputStream dataStream = TestData.class.getClassLoader().getResourceAsStream("test_data.json");
            return TestData.parseJsonStream(dataStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static StringBuilder getCallTrace() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread()
                .getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if( className.contains("org.autonoms.simulators.java")
                    && (stackTraceElement.getMethodName().compareTo("getCallTrace") !=0)){
                sb.insert(0, className + "." + stackTraceElement.getMethodName() + System.lineSeparator());
            }
        }
        return sb;
    }

    public static void copyDirectory(String sourceDirectoryLocation, String destinationDirectoryLocation)
            throws IOException {
        Files.walk(Paths.get(sourceDirectoryLocation))
                .forEach(source -> {
                    Path destination = Paths.get(destinationDirectoryLocation, source.toString()
                            .substring(sourceDirectoryLocation.length()));
                    try {
                        Files.copy(source, destination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    static private List<String> getNextName(String previousModuleName, List<String> moduleNameComponents){
        List<String> sbs = new ArrayList<>();
        for (String moduleNameComponent : moduleNameComponents){
            sbs.add(previousModuleName + moduleNameComponent);
        }
        return sbs;
    }

    static private List<String> getAllNames(
            List<String> y,
            LinkedList<List<String>> x){
        if (x.size() == 0)
            return y;
        List<String> names = new ArrayList<>();
        List<String> nextLayerModuleNames = x.pop();
        for (String previousModuleName: y) {
            names.addAll(getNextName(previousModuleName, nextLayerModuleNames));

        }
        y = names;
        return getAllNames(y, x);

    }

    static public List<String> getAllPossiblePackages(Class clazz){
        List<String> allPackages = new ArrayList<>();
        String myPackageName = clazz.getPackage().getName();
        String[] componentsPackageName = myPackageName.split("\\.");
        String postfix = "." + componentsPackageName[componentsPackageName.length - 1];
        StringBuilder prefixSb = new StringBuilder();
        for (int j=0; j < componentsPackageName.length - 3; j++){
            prefixSb.append(componentsPackageName[j]).append(".");
        }

        String thisPackageName = componentsPackageName[componentsPackageName.length - 2];
        int thisPackageIdx = TestUtils.getLastInt(thisPackageName);

        String thisModuleName = componentsPackageName[componentsPackageName.length - 3];
        LinkedList<List<String>> modulesIdentifiers = new LinkedList<>();

        if (thisModuleName.contains("_")) {
            String[] identifiersInThisModuleName = thisModuleName.split("_");
            if (identifiersInThisModuleName.length > 1) {
                for (int identifierIdx = identifiersInThisModuleName.length - 1; identifierIdx >= 0; identifierIdx--) {
                    LinkedList<String> currModuleNames = new LinkedList<>();
                    int identifier = TestUtils.getLastInt(identifiersInThisModuleName[identifierIdx]);

                    if (identifier != Integer.MIN_VALUE) {
                        for (int moduleIdx = 1; moduleIdx <= identifier; ++moduleIdx) {
                            String currModuleName = identifiersInThisModuleName[identifierIdx].replace(
                                    Integer.toString(identifier),
                                    Integer.toString(moduleIdx));
                            currModuleNames.add(currModuleName + "_");
                        }
                    } else {
                        currModuleNames.add(identifiersInThisModuleName[identifierIdx] + "_");
                    }
                    modulesIdentifiers.addFirst(currModuleNames);
                }
            }
        }

        if (modulesIdentifiers.size() > 0) {
            List<String> allNames = modulesIdentifiers.pop();
            allNames = getAllNames(allNames, modulesIdentifiers);

            for (String currModuleName : allNames) {
                for (int packageIdx = 1; packageIdx <= thisPackageIdx; ++packageIdx) {
                    String currPackageName = thisPackageName.replace(
                            Integer.toString(thisPackageIdx),
                            Integer.toString(packageIdx));
                    allPackages.add(prefixSb + currModuleName.substring(0, currModuleName.length() - 1) + "." + currPackageName + postfix);
                }
            }
        }
        return allPackages;
    }

    public static List<Method> orderMethods(List<Method> inorderedMethods){
        List<Method> ordered = new ArrayList<Method>();
        TreeMap<String, Method> methodsByName = new TreeMap<>();
        for (Method method : inorderedMethods){
            methodsByName.put(method.getDeclaringClass().getName() + "." + method.getName(), method);
        }
        for (String key: methodsByName.keySet()){
            ordered.add(methodsByName.get(key));
        }
        return ordered;
    }

    public static Map<String, TreeMap<String, Map.Entry<Class, List<Method>>>> findAllRelevantClasses(
            List<String> excludePatterns,
            List<String> includePatterns
    ) throws IOException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Map<String, TreeMap<String, Map.Entry<Class, List<Method>>>> classesMethods = new HashMap<>();
        classesMethods.put(DATA_GEN, new TreeMap<>());
        classesMethods.put(DATA_RET, new TreeMap<>());
        classesMethods.put(CLEAR_INVOKED, new TreeMap<>());
        Set<Class> classes = new ClassesFinder().findAllClassesUsingGoogleGuice(
                excludePatterns,
                includePatterns);

        for (Class clazz : classes) {
            if (clazz.isInterface())
                continue;
            Method[] declaredMethods = clazz.getDeclaredMethods();

            List<Method> methodsForDataGeneration = new ArrayList<>();
            List<Method> methodsForDataRetrieve = new ArrayList<>();
            List<Method> clearInvokedMethods = new ArrayList<>();
            try {
                clazz.getDeclaredMethod("getInstance");
                } catch(NoSuchMethodException nsmeGetInstance){
                    nsmeGetInstance.printStackTrace();
                    continue;
                }
            try {
                Method clearInvokedMethod = clazz.getDeclaredMethod("clearInvoked");
                clearInvokedMethods.add(clearInvokedMethod);
            } catch(NoSuchMethodException nsmeClearInvoked){
                nsmeClearInvoked.printStackTrace();
                continue;
            }

            for (Method method : declaredMethods) {
                if (method.getName().contains(GENERATE_DATA)) {
                    methodsForDataGeneration.add(method);
                }
                if (method.getName().contains(RETRIEVE_DATA)) {
                    methodsForDataRetrieve.add(method);
                }
            }
            if (methodsForDataGeneration.size() < 1)
                continue;
            classesMethods.get(DATA_GEN).put(clazz.getName(), new AbstractMap.SimpleEntry<Class, List<Method>>(clazz, orderMethods(methodsForDataGeneration)));
            classesMethods.get(DATA_RET).put(clazz.getName(), new AbstractMap.SimpleEntry<Class, List<Method>>(clazz, orderMethods(methodsForDataRetrieve)));
            classesMethods.get(CLEAR_INVOKED).put(clazz.getName(), new AbstractMap.SimpleEntry<Class, List<Method>>(clazz, clearInvokedMethods));
        }
        return classesMethods;

    }

    public static int getLastInt(String line)
    {
        int offset = line.length();
        for (int i = line.length() - 1; i >= 0; i--)
        {
            char c = line.charAt(i);
            if (Character.isDigit(c))
            {
                offset--;
            }
            else
            {
                if (offset == line.length())
                {
                    // No int at the end
                    return Integer.MIN_VALUE;
                }
                return Integer.parseInt(line.substring(offset));
            }
        }
        return Integer.parseInt(line.substring(offset));
    }
}
