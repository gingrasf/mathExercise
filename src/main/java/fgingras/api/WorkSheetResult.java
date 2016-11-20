package fgingras.api;


import java.util.List;

public class WorkSheetResult {
    private final static long MAX_TIME = 60000;
    private Long totalTime;
    private List<Result> results;

    public WorkSheetResult(Long totalTime, List<Result> results) {
        this.totalTime = totalTime == null ? null : totalTime / 1000;
        this.results = results;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public int getScore() {
        if (totalTime == null) {
            return results.stream().mapToInt(r -> r.isSuccess() ? 1 : 0).sum();
        }
        long timeScore = (MAX_TIME - (totalTime * 1000)) / 5000;
        int resultScore = results.stream().mapToInt(r -> r.isSuccess() ? 1 : 0).sum();
        return (int) ((resultScore + timeScore) / 20d * 100);
    }

    public List<Result> getResults() {
        return results;
    }
}
