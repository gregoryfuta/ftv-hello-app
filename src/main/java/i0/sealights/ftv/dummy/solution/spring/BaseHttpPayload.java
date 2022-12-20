package i0.sealights.ftv.dummy.solution.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import i0.sealights.ftv.dummy.test_utils.TestData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

public class BaseHttpPayload {
    TestData testData;
    LocalDateTime startTime;
    String testName;
    String testId;

    public BaseHttpPayload(){

    }

    public BaseHttpPayload(TestData testData, LocalDateTime startTime, String testName, String testId) {
        this.testData = testData;
        this.startTime = startTime;
        this.testName = testName;
        this.testId = testId;
    }

    public TestData getTestData() {
        return testData;
    }

    public void setTestData(TestData testData) {
        this.testData = testData;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "BaseHttpPayload{" +
                "testData=" + testData +
                ", startTime=" + startTime +
                ", testName='" + testName + '\'' +
                ", testId='" + testId + '\'' +
                '}';
    }

    public static BaseHttpPayload parseJsonStream(InputStream jsonStream){
        try {
            return new ObjectMapper().readValue(jsonStream, BaseHttpPayload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BaseHttpPayload parseJsonFile(File jsonDataFile){
        try {
            return new ObjectMapper().readValue(jsonDataFile, BaseHttpPayload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static BaseHttpPayload parseJsonString(String json) throws JsonProcessingException {
        try {
            return new ObjectMapper().readValue(json, BaseHttpPayload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String fromPayloadObject(BaseHttpPayload baseHttpPayload) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(baseHttpPayload);
    }
}
