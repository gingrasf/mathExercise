package fgingras.api;


import java.util.concurrent.ThreadLocalRandom;

public class Equation {
    private Operation operation;
    private int firstTerm;
    private int secondTerm;
    private int answer;
    private String userFriendlyAnswer;

    public Equation() {
    }

    public Equation(Operation operation, int firstTerm, int secondTerm) {
        this.operation = operation;
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
    }

    public Equation(Operation operation, int firstTerm, int secondTerm, int answer) {
        this.operation = operation;
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
        this.answer = answer;
        this.userFriendlyAnswer = (answer == Integer.MIN_VALUE) ? "" : Integer.toString(answer);
    }

    public static Equation fromConfig(WorkSheetConfig config) {
        Operation operation = Operation.fromInt(ThreadLocalRandom.current().nextInt(0, Operation.values().length));
        int firstTerm = ThreadLocalRandom.current().nextInt(1, config.getMaxNumber()+1);
        int secondTerm = secondTerm(config, operation, firstTerm);
        return new Equation(operation,
                firstTerm,
                secondTerm);
    }

    private static int secondTerm(WorkSheetConfig config, Operation operation, int firstTerm) {
        return operation == Operation.ADDITION
                ? ThreadLocalRandom.current().nextInt(1, config.getMaxOffset())
                : secondTermForSubstraction(config, firstTerm);
    }

    private static int secondTermForSubstraction(WorkSheetConfig config, int firstTerm) {
        return firstTerm == 1 ? 1 : ThreadLocalRandom.current().nextInt(1, Math.min(firstTerm, config.getMaxOffset()+1));
    }

    private int compute() {
        switch (operation){
            case ADDITION:
                return firstTerm+secondTerm;
            case SUBTRACTION:
                return firstTerm-secondTerm;
            default:
                return firstTerm-secondTerm;
        }
    }

    public Result resolve() {
        return new Result(this, compute());
    }

    public enum Operation {
        ADDITION,
        SUBTRACTION;

        public static Operation fromInt(int i) {
            switch (i) {
                case 0: return ADDITION;
                case 1: return SUBTRACTION;
                default: return SUBTRACTION;
            }
        }
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(int firstTerm) {
        this.firstTerm = firstTerm;
    }

    public int getSecondTerm() {
        return secondTerm;
    }

    public void setSecondTerm(int secondTerm) {
        this.secondTerm = secondTerm;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getUserFriendlyAnswer() {
        return userFriendlyAnswer;
    }

    public void setUserFriendlyAnswer(String userFriendlyAnswer) {
        this.userFriendlyAnswer = userFriendlyAnswer;
    }
}
