package i0.sealights.ftv.dummy.l1_module_run_1.pPack2;

import com.fasterxml.jackson.core.JsonProcessingException;
import i0.sealights.ftv.dummy.test_utils.TestData;
import i0.sealights.ftv.dummy.test_utils.TestMethodPair;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ComplexInterfacepPack2 {
    public void clearInvoked();
    //======================================================//
    public void fcgenerateDataIf1(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException,JsonProcessingException;
    


    public void fcgenerateDataIf2(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException,JsonProcessingException;
    


    public void fcgenerateDataIf3(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException,JsonProcessingException;
    


    public void fcgenerateDataIf4(String json, int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InterruptedException, InvocationTargetException,JsonProcessingException;
    

//======================================================//
    public List<TestData> fcretrieveDataIf1(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InvocationTargetException,InterruptedException, IllegalAccessException;
    


    public List<TestData> fcretrieveDataIf2(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InvocationTargetException,InterruptedException, IllegalAccessException;
    


    public List<TestData> fcretrieveDataIf3(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InvocationTargetException,InterruptedException, IllegalAccessException;
    


    public List<TestData> fcretrieveDataIf4(int delayMs, String byTest, int maxCallDepth, int currDepth, List<TestMethodPair> ers) throws InvocationTargetException,InterruptedException, IllegalAccessException;
    

//======================================================//
}
