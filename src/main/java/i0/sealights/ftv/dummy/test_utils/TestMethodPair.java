package i0.sealights.ftv.dummy.test_utils;

import java.time.LocalDateTime;

public class TestMethodPair {
    String testName;
    String methodName;
    int depth;
    LocalDateTime start;
    LocalDateTime end;

    public TestMethodPair(){}

    public TestMethodPair(String testName, String methodName, int depth, LocalDateTime start, LocalDateTime end) {
        this.testName = testName;
        this.methodName = methodName;
        this.depth = depth;
        this.start = start;
        this.end = end;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TestMethodPair{" +
                "testName='" + testName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", depth=" + depth +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
