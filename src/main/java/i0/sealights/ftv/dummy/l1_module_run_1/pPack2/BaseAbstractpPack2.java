package i0.sealights.ftv.dummy.l1_module_run_1.pPack2;

import com.fasterxml.jackson.core.JsonProcessingException;
import i0.sealights.ftv.dummy.l1_module_run_1.pPack2.BaseInterfacepPack2;
import i0.sealights.ftv.dummy.test_utils.TestData;
import i0.sealights.ftv.dummy.test_utils.TestMethodPair;
import i0.sealights.ftv.dummy.test_utils.TestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseAbstractpPack2 {

    private static BaseAbstractpPack2 INSTANCE;
    static final Logger LOGGER = LogManager.getLogger(BaseAbstractpPack2.class);
    private TreeMap<String, Map.Entry<Class, List<Method>>> mapClasses2DataGenerationMethods;
    private TreeMap<String, Map.Entry<Class, List<Method>>> mapClasses2DataRetrieveMethods;
    private final TestData testData;
    public Set<String> invoked;

    public Map<String, Object> getInitialized() {
        return initialized;
    }

    private final Map<String, Object> initialized;

    private Object getInitializedClass(String className, Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object initializedClassInstance = initialized.get(className);
        if (initializedClassInstance == null){
            initializedClassInstance =clazz.getDeclaredMethod("getInstance").invoke(null);
            initialized.put(className, initializedClassInstance);
        }
        return initializedClassInstance;
    }

    public static BaseAbstractpPack2 getInstance(){
        if( INSTANCE == null){
            INSTANCE = new BaseAbstractpPack2();
        }
        return INSTANCE;
    }
    private List<String> getExcludes(){
        List<String> excludes = new ArrayList<>();
        excludes.add(this.getClass().getName());
        excludes.add("Complex");
        excludes.add("Abstract");
        excludes.add("Test");
        return excludes;
    }

    private List<String> getIncludes(){
        List<String> includes = new ArrayList<>();
        includes.add(this.getClass().getPackage().getName());
        includes.add("Pack");
        includes.add("Impl");
        return includes;
    }

    private BaseAbstractpPack2(){
        invoked = new HashSet<>();
        initialized = new HashMap<>();
        try {
            Map<String, TreeMap<String, Map.Entry<Class, List<Method>>>> mapClasses2Methods = TestUtils.findAllRelevantClasses(getExcludes(), getIncludes());
            mapClasses2DataGenerationMethods = mapClasses2Methods.get(TestUtils.DATA_GEN);
            mapClasses2DataRetrieveMethods  = mapClasses2Methods.get(TestUtils.DATA_RET);
        } catch (Exception e){
            mapClasses2DataGenerationMethods = new TreeMap<>();
            mapClasses2DataRetrieveMethods = new TreeMap<>();
        }
        this.testData = TestUtils.getTestData();
    }

    //======================================================//
    public void dataGenerator(String json, int delayMs, String caller, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException{
        LocalDateTime commonStart = LocalDateTime.now();
        String methodName = this.getClass().getName() + ".dataGenerator";
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    commonStart,
                    LocalDateTime.now()
            ));
            return;
        }
        try {
            for (Map.Entry<String, Map.Entry<Class, List<Method>>> class2MethodsInThisModule: mapClasses2DataGenerationMethods.entrySet()){
                for (Method method : class2MethodsInThisModule.getValue().getValue()) {
                    if (!method.getName().contains(TestUtils.GENERATE_DATA))
                        continue;
                    String toBeInvoked = class2MethodsInThisModule.getKey() +
                            "." + method.getName();
                    if (invoked.contains(toBeInvoked))
                        continue;
                    invoked.add(toBeInvoked);
                    long start = System.nanoTime();
                    method.invoke(
                            getInitializedClass(
                                    class2MethodsInThisModule.getValue().getKey().getName(),
                                    class2MethodsInThisModule.getValue().getKey()),
                            json, delayMs, byTest, maxCallDepth, currDepth + 1, ers);
                    LOGGER.debug(">>> Test: " + byTest + "\n" +
                            "=== Invoker: " + caller +"\n" +
                            "--- Class method:  " + toBeInvoked + " at depth " + (currDepth + 1) +
                            ", duration: " + (start - System.nanoTime()) + "[ns]"
                    );
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                commonStart,
                LocalDateTime.now()
        ));
    }
    //======================================================//
    public TestData dataRetriever(int delayMs, String caller, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        LocalDateTime commonStart = LocalDateTime.now();
        String methodName = this.getClass().getName() + ".dataRetriever";
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    commonStart,
                    LocalDateTime.now()
            ));
            return this.testData;
        }
        try {
            for (Map.Entry<String, Map.Entry<Class, List<Method>>> class2MethodsInThisModule: mapClasses2DataRetrieveMethods.entrySet()){
                for (Method method : class2MethodsInThisModule.getValue().getValue()) {
                    if (!method.getName().contains(TestUtils.RETRIEVE_DATA))
                        continue;
                    String toBeInvoked = class2MethodsInThisModule.getKey() +
                            "." + method.getName();
                    if (invoked.contains(toBeInvoked))
                        continue;
                    invoked.add(toBeInvoked);
                    long start = System.nanoTime();
                    method.invoke(
                            getInitializedClass(class2MethodsInThisModule.getValue().getKey().getName(), class2MethodsInThisModule.getValue().getKey()),
                            delayMs, byTest, maxCallDepth, currDepth + 1, ers);
                    LOGGER.debug(">>> Test: " + byTest + "\n" +
                            "=== Invoker: " + caller +"\n" +
                            "--- Class method:  " + toBeInvoked + " at depth " + (currDepth + 1) +
                            ", duration: " + (start - System.nanoTime()) + "[ns]"
                    );
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                commonStart,
                LocalDateTime.now()
        ));
        return this.testData;
    }
    //======================================================//
}
