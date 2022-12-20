package i0.sealights.ftv.dummy.test_utils;

public class TestType {

    long numMethodsToBeCalledPerSec;
    double testTimeSec;
    int maxCallDepth;

    public TestType(){}

    public TestType(long numMethodsToBeCalledPerSec, double testTimeSec, int maxCallDepth) {
        this.numMethodsToBeCalledPerSec = numMethodsToBeCalledPerSec;
        this.testTimeSec = testTimeSec;
        this.maxCallDepth = maxCallDepth;
    }

    public long getNumMethodsToBeCalledPerSec() {
        return numMethodsToBeCalledPerSec;
    }

    public void setNumMethodsToBeCalledPerSec(long numMethodsToBeCalledPerSec) {
        this.numMethodsToBeCalledPerSec = numMethodsToBeCalledPerSec;
    }

    public double getTestTimeSec() {
        return testTimeSec;
    }

    public void setTestTimeSec(double testTimeSec) {
        this.testTimeSec = testTimeSec;
    }

    public int getMaxCallDepth() {
        return maxCallDepth;
    }

    public void setMaxCallDepth(int maxCallDepth) {
        this.maxCallDepth = maxCallDepth;
    }

    @Override
    public String toString() {
        return "TestType{" +
                "numMethodsToBeCalledPerSec=" + numMethodsToBeCalledPerSec +
                ", testTimeSec=" + testTimeSec +
                ", maxCallDepth=" + maxCallDepth +
                '}';
    }
}


