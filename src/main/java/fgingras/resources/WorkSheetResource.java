package fgingras.resources;

import com.codahale.metrics.annotation.Timed;
import fgingras.api.WorkSheet;
import fgingras.api.WorkSheetConfig;
import fgingras.api.WorkSheetOptions;
import fgingras.api.WorkSheetView;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/math/worksheet")
@Produces(MediaType.TEXT_HTML)
public class WorkSheetResource {

    @GET
    @Timed
    public WorkSheetView worksheet(@DefaultValue("3") @QueryParam("level") int level, @DefaultValue("true") @QueryParam("time") boolean time) {
        return new WorkSheetView(new WorkSheet(toLevel(level), new WorkSheetOptions(time)));
    }

    private WorkSheetConfig toLevel(int level) {
        if (level == 1) {
            return WorkSheetConfig.FIRST_LEVEL;
        }
        return WorkSheetConfig.THIRD_LEVEL;
    }
}
