<%--
  Created by IntelliJ IDEA.
  User: jaroslaw
  Date: 10/24/20
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>
<c:url var="edit_url" value="/admin/books/edit"/>
<%--@elvariable id="book" type=""--%>
<form:form method="post" modelAttribute="book" action="${edit_url}">
    <form:hidden path="id"/>
    <form:input path="isbn"/>
    <form:errors path="isbn"/><br/>
    <form:input path="title"/>
    <form:errors path="title"/><br/>
    <form:input path="author"/>
    <form:errors path="author"/><br/>
    <form:input path="publisher"/>
    <form:errors path="publisher"/><br/>
<%--    <form:input path="type"/>--%>
    <form:select path="type">
    <form:option value="type" label="--Please Select--"/>
    <form:options items="${types}"/>
    </form:select><br/>
    <form:errors path="type"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>