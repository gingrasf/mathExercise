package fgingras.resources;

import fgingras.api.Equation;
import fgingras.api.ResultView;
import fgingras.api.WorkSheet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Path("/math/result")
@Produces(MediaType.TEXT_HTML)
public class ResultResource {


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public ResultView result(MultivaluedMap<String, String> workSheet) {
        return new ResultView(toWorkSheet(workSheet));
    }

    private WorkSheet toWorkSheet(MultivaluedMap<String, String> workSheet) {
        return new WorkSheet(safelyAssignStartTime(workSheet), toEquationList(workSheet));
    }

    private Long safelyAssignStartTime(MultivaluedMap<String, String> workSheet) {
        return workSheet.getFirst("start") == null ? null : Long.valueOf(workSheet.getFirst("start"));
    }

    private List<Equation> toEquationList(MultivaluedMap<String, String> workSheet) {
        return IntStream.range(0, workSheet.get("operation").size())
                .mapToObj(i ->
                        new Equation(toOperation(workSheet, i),
                                safeIntValue(workSheet.get("firstTerm").get(i)),
                                safeIntValue(workSheet.get("secondTerm").get(i)),
                                safeIntValue(workSheet.get("answer").get(i)))
                ).collect(Collectors.toList());
    }

    private Integer safeIntValue(String firstTerm) {
        try {
            return Integer.valueOf(firstTerm);
        }
        catch (NumberFormatException e) {
            return Integer.MIN_VALUE;
        }
    }

    private Equation.Operation toOperation(MultivaluedMap<String, String> workSheet, int i) {
        return Equation.Operation.valueOf(workSheet.get("operation").get(i));
    }

}