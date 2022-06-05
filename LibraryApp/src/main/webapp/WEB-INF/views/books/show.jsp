<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 04.06.2022
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book's details</title>
</head>
<body>
<table>
    <thead>
    <th>Title</th>
    <th>Author</th>
    <th>ISBN</th>
    <th>Publisher</th>
    <th>Category</th>
    <th>Description</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.author}"/></td>
        <td><c:out value="${book.isbn}"/></td>
        <td><c:out value="${book.publisher}"/></td>
        <td><c:out value="${book.description}"/></td>

    </tr>
    </tbody>
</table>
</body>
</html>
