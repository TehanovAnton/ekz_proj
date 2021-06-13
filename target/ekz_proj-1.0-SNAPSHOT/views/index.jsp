<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classes.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <form action="KeyValueArrayByRadioServlet" method="post">
        <input type="radio" name="radios" value="1">
        <input type="radio" name="radios" value="2">
        <input type="radio" name="radios" value="3">
        <input type="submit" value="send">
    </form><br>

    <form action="welcome1" method="post">
        <input type="text" name="key">
        <input type="text" name="value">
        <input type="submit">
    </form><br>

    <form action="AddKeyValueServlet" method="post">
        Key:    <input type="text" name="Key"><br>
        Value:  <input type="text" name="Value"><br>
        <input type="submit">
    </form><br>

<%--    подключение и ввод данных--%>
    <sql:setDataSource var="db"
                       driver="${DatabaseConnection.MS_JDBC_DRIVER}"
                       url="${DatabaseConnection.MS_DB_URL}"
                       user="${DatabaseConnection.MS_USER_NAME}"
                       password="${DatabaseConnection.MS_PASSWORD}"/>
    <sql:update dataSource="${db}" var="count">
        insert into KeyValueTable(k, v, serialized)
            values(5, 'e', 'this serialized')
    </sql:update>

<%--    запрос и вывод результата--%>
    <sql:query dataSource="${db}" var="rs">
        select * from KeyValueTable
    </sql:query>
    <c:forEach var="el" items="${rs.rows}">
        <c:out value="${el.k} : ${el.v} -> ${el.serialized}"/><br>
    </c:forEach>

<%--    update с параметромм--%>
    <c:set var="k" value="5"/>
    <sql:update dataSource="${db}" var="count">
        delete from KeyValueTable where k = ?
        <sql:param value="${k}"/>
    </sql:update><br>

<%--    customtag--%>
    <%@taglib prefix="ct" uri="customtag"%>
    <ct:customtag text="hello body"/>

    <%@taglib prefix="fct" uri="functionTag"%>
    <c:out value="${fct:functionTag(\"someText\")}"/>
</body>
</html>