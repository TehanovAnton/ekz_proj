<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 12.06.2021
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="el" items="${arr}">
        <c:out value="${el}"/>
    </c:forEach>
</body>
</html>
