package i0.sealights.ftv.dummy.test_utils;

import java.util.List;

public class ExecutionReport {
    private long numCalledMethods;
    private double executionTimeNs;
    private String caller;
    private List<CalledMethodEntry> calledMethods;
    private List<TestMethodPair> tmPairs;
    List<ExecutionReport> erReports;

    public long getNumCalledMethods() {
        return numCalledMethods;
    }

    public void setNumCalledMethods(long numCalledMethods) {
        this.numCalledMethods = numCalledMethods;
    }

    public double getExecutionTimeNs() {
        return executionTimeNs;
    }

    public void setExecutionTimeNs(double executionTimeNs) {
        this.executionTimeNs = executionTimeNs;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public List<CalledMethodEntry> getCalledMethods() {
        return calledMethods;
    }

    public void setCalledMethods(List<CalledMethodEntry> calledMethods) {
        this.calledMethods = calledMethods;
    }

    public void setErReports(List<ExecutionReport> erReports){
        this.erReports = erReports;
    }

    public List<ExecutionReport> getErReports() {
        return erReports;
    }

    public List<TestMethodPair> getTmPairs() {
        return tmPairs;
    }

    public void setTmPairs(List<TestMethodPair> tmPairs) {
        this.tmPairs = tmPairs;
    }

    @Override
    public String toString() {
        return "ExecutionReport{" +
                "numCalledMethods=" + numCalledMethods +
                ", executionTimeNs=" + executionTimeNs +
                ", caller='" + caller + '\'' +
                '}';
    }
}
