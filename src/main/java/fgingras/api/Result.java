package fgingras.api;


public class Result {

    private boolean success;
    private int correctAnswer;
    private Equation equation;

    public Result(Equation equation, int correctAnswer) {
        this.equation = equation;
        this.correctAnswer = correctAnswer;
        this.success = equation.getAnswer() == correctAnswer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
    }
}
