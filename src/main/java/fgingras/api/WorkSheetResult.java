package fgingras.api;


import java.util.List;

public class WorkSheetResult {
    private final static long MAX_TIME = 60000;
    private long totalTime;
    private List<Result> results;

    public WorkSheetResult(long totalTime, List<Result> results) {
        this.totalTime = totalTime/1000;
        this.results = results;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public double getScore() {
        long timeScore = (MAX_TIME - (totalTime*1000))/5000;
        int resultScore = results.stream().mapToInt(r->r.isSuccess()?1:0).sum();
        return (resultScore + timeScore)/20d * 100;
    }

    public List<Result> getResults() {
        return results;
    }
}
