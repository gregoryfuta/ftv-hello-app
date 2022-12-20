package i0.sealights.ftv.dummy.l1_module_run_1.pPack1.impl;
import i0.sealights.ftv.dummy.l1_module_run_1.pPack1.BaseAbstractpPack1;
import i0.sealights.ftv.dummy.l1_module_run_1.pPack1.BaseInterfacepPack1;

import com.fasterxml.jackson.core.JsonProcessingException;
import i0.sealights.ftv.dummy.test_utils.*;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BasepPack1Impl300 implements BaseInterfacepPack1{
    private static final Logger LOGGER = LogManager.getLogger(BasepPack1Impl300.class);
    private static BasepPack1Impl300 INSTANCE;
    private BaseAbstractpPack1 parent;

    public static BasepPack1Impl300 getInstance(){
        if( INSTANCE == null){
            INSTANCE = new BasepPack1Impl300();
        }
        return INSTANCE;
    }

    private BasepPack1Impl300(){
        this.parent = BaseAbstractpPack1.getInstance();
    }

    public void clearInvoked(){
        this.parent.invoked.clear();
    }

    //======================================================//
    public void fcgenerateDataIf1(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException {
        String methodName = this.getClass().getName() + ".fcgenerateDataIf1";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return;
        }
    }
    


    public void fcgenerateDataIf2(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException {
        String methodName = this.getClass().getName() + ".fcgenerateDataIf2";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return;
        }
    }
    


    public void fcgenerateDataIf3(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException {
        String methodName = this.getClass().getName() + ".fcgenerateDataIf3";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return;
        }
    }
    


    public void fcgenerateDataIf4(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException {
        String methodName = this.getClass().getName() + ".fcgenerateDataIf4";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return;
        }
    }
    

//======================================================//
    public TestData fcretrieveDataIf1(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf1";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >=  maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return TestUtils.getTestData();
        }
        TestData td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public TestData fcretrieveDataIf2(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf2";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >=  maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return TestUtils.getTestData();
        }
        TestData td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public TestData fcretrieveDataIf3(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf3";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >=  maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return TestUtils.getTestData();
        }
        TestData td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public TestData fcretrieveDataIf4(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf4";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >=  maxCallDepth) {
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return TestUtils.getTestData();
        }
        TestData td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    

//======================================================//
}
