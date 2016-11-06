<#-- @ftlvariable name="" type="fgingras.api.WorkSheetView" -->
<html>
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="/math.css">
    </head>
    <body onload="init()">
        <h1>Exercices</h1>
        <form action="/api/math/result" method="post">
            <input type="hidden" name="start" value="${workSheet.start?c}">
            <table style="width:50%;font-size:1em">
           <#list workSheet.equations as equation>
              <tr>
                <input type="hidden" name="operation" value="${equation.operation}">
                <input type="hidden" name="firstTerm" value="${equation.firstTerm}">
                <input type="hidden" name="secondTerm" value="${equation.secondTerm}">
                <td>${equation.firstTerm}
                <#if equation.operation == "ADDITION">
                    +
                <#else>
                    -
                </#if>
                ${equation.secondTerm}</td>
                <td>=</td>
                <td>
                 <input type="text" name="answer" autocomplete="off" value="">
                </td>
              </tr>
            </#list>
            </table>
            <input class="button" type="submit" value="J'ai finis!" />
        </form>
        <!-- <button class="button" type="button" onclick="completed()">J'ai finis!</button> -->
        <div id="message" style="display:none;">
        <p id="time"></p>
        </div>
    </body>
        <script type="text/javascript">
            //var startTime = ${workSheet.start};
            var startTime;

            function init() {
                startTime = new Date().getTime();
            }

            function completed(){
                var now = new Date().getTime();
                document.getElementById("time").innerHTML = (now-startTime)/1000+" secondes";
                showMessage();
            }

            function showMessage() {
                document.getElementById("message").style.display = "block";
            }
        </script>
</html>