<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 11.06.2021
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String m = (String) request.getAttribute("errorType");
    %>
    <p>hello body!</p><br>
    <div>that is error page.</div><%=m%>
</body>
</html>
