package fgingras;

import fgingras.api.WorkSheetView;
import fgingras.resources.ExerciseResource;
import fgingras.resources.ResultResource;
import fgingras.resources.WorkSheetResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Map;

public class MathExerciseApplication extends Application<MathExerciseConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MathExerciseApplication().run(args);
    }

    @Override
    public String getName() {
        return "mathExercise";
    }

    @Override
    public void initialize(final Bootstrap<MathExerciseConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<>());
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }


    @Override
    public void run(final MathExerciseConfiguration configuration,
                    final Environment environment) {
        final ExerciseResource exerciseResource = new ExerciseResource();
        environment.jersey().register(exerciseResource);
        final WorkSheetResource workSheetResource = new WorkSheetResource();
        environment.jersey().register(workSheetResource);
        final ResultResource resultResource = new ResultResource();
        environment.jersey().register(resultResource);
    }

}
