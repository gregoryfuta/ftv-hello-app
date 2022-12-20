package i0.sealights.ftv.dummy.test_utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestData {
    private int pkg;
    private int cls;
    private String testDate;
    TestType fastTests;
    TestType mediumTests;
    TestType slowTests;

    public TestData(){}

    public int getPkg() {
        return pkg;
    }

    public void setPkg(int pkg) {
        this.pkg = pkg;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public TestType getFastTests() {
        return fastTests;
    }

    public void setFastTests(TestType fastTests) {
        this.fastTests = fastTests;
    }

    public TestType getMediumTests() {
        return mediumTests;
    }

    public void setMediumTests(TestType mediumTests) {
        this.mediumTests = mediumTests;
    }

    public TestType getSlowTests() {
        return slowTests;
    }

    public void setSlowTests(TestType slowTests) {
        this.slowTests = slowTests;
    }

    @Override
    public String toString() {
        return "TestData{" +
                ", pkg=" + pkg +
                ", cls=" + cls +
                ", testDate='" + testDate + '\'' +
                ", fastTests=" + fastTests +
                ", mediumTests=" + mediumTests +
                ", slowTests=" + slowTests +
                '}';
    }

    public static TestData parseJsonStream(InputStream jsonStream){
        try {
            return new ObjectMapper().readValue(jsonStream, TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TestData parseJsonFile(File jsonDataFile){
        try {
            return new ObjectMapper().readValue(jsonDataFile, TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static TestData parseJsonString(String json) throws JsonProcessingException{
        try {
            return new ObjectMapper().readValue(json, TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fromTestData(TestData testData) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(testData);
    }

}
