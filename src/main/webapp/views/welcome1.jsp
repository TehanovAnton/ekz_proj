  Created by IntelliJ IDEA.
  User: Anton
  Date: 12.06.2021
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page%>>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <jsp:useBean id="obj" class="classes.KeyValueTable" />
  <jsp:setProperty name="obj" property="*" />
  <br>
  <%
    out.println(obj.key + obj.value);
  %>

</body>
</html>
