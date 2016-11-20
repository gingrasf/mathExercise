package fgingras.api;


public class WorkSheetConfig {

    public static WorkSheetConfig THIRD_LEVEL = new WorkSheetConfig(20, 20, 12);
    public static WorkSheetConfig FIRST_LEVEL = new WorkSheetConfig(20, 10, 10);

    private int equationsCount = 20;
    private int maxNumber = 20;
    private int maxOffset = 6;

    public WorkSheetConfig(int equationsCount, int maxNumber, int maxOffset) {
        this.equationsCount = equationsCount;
        this.maxNumber = maxNumber;
        this.maxOffset = maxOffset;
    }

    public int getEquationsCount() {
        return equationsCount;
    }

    public void setEquationsCount(int equationsCount) {
        this.equationsCount = equationsCount;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getMaxOffset() {
        return maxOffset;
    }

    public void setMaxOffset(int maxOffset) {
        this.maxOffset = maxOffset;
    }
}
