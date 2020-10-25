<%--
  Created by IntelliJ IDEA.
  User: jaroslaw
  Date: 10/24/20
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${book.isbn}"/></td>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.author}"/></td>
        <td><c:out value="${book.publisher}"/></td>
        <td><c:out value="${book.type}"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<a href="<c:url value="/admin/books/all"/>">Powrót</a>
</body>
</html>
