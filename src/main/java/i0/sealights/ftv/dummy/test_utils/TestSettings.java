package i0.sealights.ftv.dummy.test_utils;

public class TestSettings {
    private TestData testDataObject;

    public TestSettings(TestData testDataObject){
        this.testDataObject = testDataObject;
    }

    public TestData getTestDataObject() {
        return testDataObject;
    }

    public void setTestDataObject(TestData testDataObject) {
        this.testDataObject = testDataObject;
    }

    @Override
    public String toString() {
        return "TestSettings{" +
                "testDataObject=" + testDataObject +
                '}';
    }
}
