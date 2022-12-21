package i0.sealights.ftv.dummy.l1_module_run_1.pPack2.impl;

import i0.sealights.ftv.dummy.l1_module_run_1.pPack2.ComplexAbstractpPack2;
import i0.sealights.ftv.dummy.l1_module_run_1.pPack2.ComplexInterfacepPack2;
import com.fasterxml.jackson.core.JsonProcessingException;
import i0.sealights.ftv.dummy.test_utils.TestData;
import i0.sealights.ftv.dummy.test_utils.TestMethodPair;
import i0.sealights.ftv.dummy.test_utils.TestUtils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ComplexpPack2Impl686 implements ComplexInterfacepPack2{
    static final Logger LOGGER = LogManager.getLogger(ComplexpPack2Impl686.class);
    private ComplexAbstractpPack2 parent;
    private static ComplexpPack2Impl686 INSTANCE;

    public static ComplexpPack2Impl686 getInstance(){
        if( INSTANCE == null){
            INSTANCE = new ComplexpPack2Impl686();
        }
        return INSTANCE;
    }

    private ComplexpPack2Impl686(){
        this.parent = ComplexAbstractpPack2.getInstance();
    }

    public void clearInvoked(){
        this.parent.invoked.clear();
    }

    //======================================================//
    public void fcgenerateDataIf1(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException{
        String methodName = this.getClass().getName() + ".fcgenerateDataIf1";
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
            return;
        }
        parent.dataGenerator(json, delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
    }
    


    public void fcgenerateDataIf2(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException{
        String methodName = this.getClass().getName() + ".fcgenerateDataIf2";
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
            return;
        }
        parent.dataGenerator(json, delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
    }
    


    public void fcgenerateDataIf3(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException{
        String methodName = this.getClass().getName() + ".fcgenerateDataIf3";
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
            return;
        }
        parent.dataGenerator(json, delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
    }
    


    public void fcgenerateDataIf4(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, JsonProcessingException{
        String methodName = this.getClass().getName() + ".fcgenerateDataIf4";
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
            return;
        }
        parent.dataGenerator(json, delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
    }
    

//======================================================//
    public List<TestData> fcretrieveDataIf1(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf1";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            List<TestData> x = new ArrayList<>();
            x.add(TestUtils.getTestData());
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return x;
        }
        List<TestData> td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public List<TestData> fcretrieveDataIf2(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf2";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            List<TestData> x = new ArrayList<>();
            x.add(TestUtils.getTestData());
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return x;
        }
        List<TestData> td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public List<TestData> fcretrieveDataIf3(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf3";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            List<TestData> x = new ArrayList<>();
            x.add(TestUtils.getTestData());
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return x;
        }
        List<TestData> td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
        ers.add(new TestMethodPair(
                byTest,
                methodName,
                currDepth,
                start,
                LocalDateTime.now()
        ));
        return td;
    }
    


    public List<TestData> fcretrieveDataIf4(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException, IllegalAccessException {
        String methodName = this.getClass().getName() + ".fcretrieveDataIf4";
        LocalDateTime start = LocalDateTime.now();
        LOGGER.debug("Method " + methodName + " at the depth " + currDepth + " was called by test " + byTest);
        if (currDepth >= maxCallDepth) {
            List<TestData> x = new ArrayList<>();
            x.add(TestUtils.getTestData());
            ers.add(new TestMethodPair(
                    byTest,
                    methodName,
                    currDepth,
                    start,
                    LocalDateTime.now()
            ));
            return x;
        }
        List<TestData> td = parent.dataRetriever(delayMs, methodName, byTest, maxCallDepth, currDepth + 1, ers);
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