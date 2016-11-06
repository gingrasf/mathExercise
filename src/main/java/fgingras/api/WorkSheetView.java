package fgingras.api;

import io.dropwizard.views.View;

public class WorkSheetView extends View {

    private final WorkSheet workSheet;

    public WorkSheetView(WorkSheet workSheet) {
        super("worksheet.ftl");
        this.workSheet = workSheet;
    }

    public WorkSheet getWorkSheet() {
        return workSheet;
    }
}

