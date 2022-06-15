<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 04.06.2022
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book list</title>
    <a href="<c:url value="/books/all"/>">Books</a>
    <a href="<c:url value="/users/all"/>">Users</a>
    <a href="<c:url value="/categories/all"/>">Categories</a>
    <a href="<c:url value="/lend/all"/>">Lendings</a><br>
</head>
<body>
<a href="<c:url value="/books/add"/>">Add book</a>
<table>
    <thead>
    <th>Title</th>
    <th>Author</th>
    <th>ISBN</th>
    <th>Publisher</th>
    <th>Category</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.category.name}"/></td>
            <td>
                <a href="<c:url value="/books/delete/${book.id}"/>">Delete</a>
                <a href="<c:url value="/books/edit/${book.id}"/>">Update</a>
                <a href="<c:url value="/books/show/${book.id}"/>">Details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <form:select itemValue="id" itemLabel="name" path="category.id"
                 items="${categories}" />
    <a href="<c:url value="/books/show/category/${categories.indexOf(id)}"/>">Filtr by Category</a>

</table>
</body>
</html>
