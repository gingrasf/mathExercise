package fgingras.api;


import io.dropwizard.views.View;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ResultView extends View {

    private final WorkSheet workSheet;

    public ResultView(WorkSheet workSheet) {
        super("result.ftl");
        this.workSheet = workSheet;
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }

    public WorkSheetResult getResult() {
        return new WorkSheetResult(computeTotalTime(workSheet.getStart()), workSheet.getEquations().stream().map(eq->eq.resolve()).collect(Collectors.toList()));
    }

    private Long computeTotalTime(Long start) {
        if(start == null) {
            return null;
        }
        Instant startInstant = Instant.ofEpochMilli(start);
        return (Instant.now().toEpochMilli() - startInstant.toEpochMilli());
    }
}
