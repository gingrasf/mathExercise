package fgingras.api;


import io.dropwizard.views.View;

public class ExerciseView extends View {

    private final Exercise exercise;

    public ExerciseView(Exercise Exercise) {
        super("exercise.ftl");
        this.exercise = Exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }
}
