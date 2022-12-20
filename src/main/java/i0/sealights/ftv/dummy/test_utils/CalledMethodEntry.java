package i0.sealights.ftv.dummy.test_utils;

public class CalledMethodEntry {
    private String className;
    private String methodName;
    private long executionTimeNs;

    public CalledMethodEntry(){}

    public CalledMethodEntry(String className, String methodName, long executionTimeNs) {
        this.className = className;
        this.methodName = methodName;
        this.executionTimeNs = executionTimeNs;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getExecutionTimeNs() {
        return executionTimeNs;
    }

    public void setExecutionTimeNs(long executionTimeNs) {
        this.executionTimeNs = executionTimeNs;
    }

    @Override
    public String toString() {
        return "CalledMethodEntry{" +
                "method='" + className + '.' + methodName + '\'' +
                ", executionTimeNs=" + executionTimeNs +
                '}';
    }
}
