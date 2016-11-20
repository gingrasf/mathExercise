<#-- @ftlvariable name="" type="fgingras.api.ResultView" -->
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="/math.css">
    </head>
    <body>
        <h1>Resultats</h1>
        <#if result.totalTime??>
        <p class="result-label">
        <strong>Temps Total: </strong>  ${result.totalTime?c} secondes
        </p>
        </#if>
        <p class="result-label">
        <strong>Note: </strong>  ${result.score?c} points !
        </p>
        <p class="result-label">
        <strong>Correction </strong>
        </p>
           <table style="width:50%" class="result">
           <tr>
           <th>Equation</th>
           <th>Ta réponse</th>
           <th>Bonne réponse</th>
           </tr>
           <#list result.results as res>
              <tr class="${res.success?then('success', 'error')}">
                <td class="result">${res.equation.firstTerm}
                <#if res.equation.operation == "ADDITION">
                    +
                <#else>
                    -
                </#if>
                ${res.equation.secondTerm?c}</td>
                </td>
                <td class="result">
                  ${res.equation.userFriendlyAnswer}
                </td>
                <td class="result">
                  ${res.correctAnswer?c}
                </td>
              </tr>
            </#list>
            </table>
        </form>
        <div class="button-div">
        <a class="button" href="/api/math/worksheet">J'essaie encore!</a>
        </div>
    </body>
</html>