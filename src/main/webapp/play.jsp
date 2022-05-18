<%@ page import="ua.kharkov.kpi.jmt.xmath.Expression" %>
<%@ page import="ua.kharkov.kpi.jmt.xmath.ExpressionFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: danya
  Date: 17/05/2022
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JavaMathTest - Play</title>

    <link rel="stylesheet" href="styles/background.css">
    <link rel="stylesheet" href="styles/main.css">

    <style>
        .divTest {
            display: none;
        }

        input[type='button'] {
            color: white;
            padding: 10px;
            background: none;
            border: 5px solid rgb(255, 255, 0);
        }
    </style>
</head>
<body>
<ul class="circles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
<div id="content">
    <%
        Expression[] expressions = ExpressionFactory.getSimpleExpressions();
    %>

    <% for (Expression expression : expressions) { %>
    <div class="divTest">
        <%out.println(expression.getExpression() + " = ");%>
        <label>
            <input type="number">
        </label>
    </div>
    <%}%>

    <input type="button" value="Start test" id="btnStart">

    <div id="divRes" style="display: none"></div>

    <script src="scripts/stopwatch.js"></script>
    <script src="scripts/play.js"></script>
    <script>
        let answers = [<%for(Expression expression: expressions) out.print(expression.getAnswer() + ", ");%>];
        let btnStart = document.getElementById("btnStart");

        btnStart.addEventListener("click", () => {
            btnStart.style.display = "none";
            start();
        });
    </script>
</div>
</body>
</html>
