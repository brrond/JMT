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
    <title>JavaMathTest - Message</title>

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
    <%
        String msg = (String) request.getAttribute("msg");
        String redirect = (String) request.getAttribute("redirect");
    %>

    <h2><%out.print(msg);%></h2><br><br>
    <a href="<%out.print(redirect);%>">Ok</a>

</div>
</body>
</html>
