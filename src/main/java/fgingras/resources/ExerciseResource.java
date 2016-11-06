package fgingras.resources;


import com.codahale.metrics.annotation.Timed;
import fgingras.api.Exercise;
import fgingras.api.ExerciseView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/math/exercise")
@Produces(MediaType.TEXT_HTML)
public class ExerciseResource {


    @GET
    @Timed
    public ExerciseView workbook() {
        return new ExerciseView(new Exercise());
    }

}
