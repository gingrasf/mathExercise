package fgingras.api;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class WorkSheet {
    private long start;
    private WorkSheetConfig config;
    private List<Equation> equations;

    public WorkSheet() {
    }

    public WorkSheet(long start, List<Equation> equations) {
        this.start = start;
        this.equations = equations;
    }

    public WorkSheet(WorkSheetConfig config) {
        this.config = config;
        this.equations = generateEquations(config);
        start = Instant.now().toEpochMilli();
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public WorkSheetConfig getConfig() {
        return config;
    }

    public void setConfig(WorkSheetConfig config) {
        this.config = config;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    private static List<Equation> generateEquations(WorkSheetConfig config) {
        return IntStream.range(1,(config.getEquationsCount()+1)).mapToObj(i->generateEquation(config)).collect(toList());
    }

    private static Equation generateEquation(WorkSheetConfig config) {
        return Equation.fromConfig(config);
    }
}
