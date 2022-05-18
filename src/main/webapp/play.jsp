<%@ page import="ua.kharkov.kpi.jmt.xmath.Expression" %>
<%@ page import="ua.kharkov.kpi.jmt.xmath.ExpressionFactory" %>
<%@ page import="ua.kharkov.kpi.jmt.model.User" %>
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
        User user = (User) session.getAttribute("user");
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
        let experience = [<%
        for(Expression expression: expressions) {
            switch (expression.getOperation()) {
                case "/": out.print(1); break;
                case "*": out.print(0.75); break;
                case "-": out.print(0.5); break;
                default : out.print(0.25); break;
            }
            out.print(", ");
        };%>];
        let experienceToNextLevel = <%out.print(user.getExperienceToNextLevel());%>;
        let userAnswers = []
        let btnStart = document.getElementById("btnStart");

        btnStart.addEventListener("click", () => {
            btnStart.style.display = "none";
            start();
        });
    </script>
</div>
</body>
</html>
