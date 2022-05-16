<%--
  Created by IntelliJ IDEA.
  User: danya
  Date: 16/05/2022
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JavaMathTest - Logout</title>

    <link rel="stylesheet" href="styles/background.css">
    <link rel="stylesheet" href="styles/main.css">
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
    <h1>Logout successful</h1><br><br>
    <a href="index.html">To main page</a>

    <%session.invalidate();%>
</div>
</body>
</html>
