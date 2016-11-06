package fgingras.resources;

import com.codahale.metrics.annotation.Timed;
import fgingras.api.Exercise;
import fgingras.api.ExerciseView;
import fgingras.api.ResultView;
import fgingras.api.WorkSheet;
import fgingras.api.WorkSheetConfig;
import fgingras.api.WorkSheetView;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/math/worksheet")
@Produces(MediaType.TEXT_HTML)
public class WorkSheetResource {

    @GET
    @Timed
    public WorkSheetView worksheet() {
        return new WorkSheetView(new WorkSheet(WorkSheetConfig.DEFAULT));
    }

}
