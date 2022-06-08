<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 05.06.2022
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<a href="<c:url value="/categories/add"/>">Add category</a>
<table>
    <thead>
    <th>Category</th>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><c:out value="${category.name}"/></td>

            <td>
                <a href="<c:url value="/categories/delete/${category.id}"/>">Delete</a>
                <a href="<c:url value="/categories/edit/${category.id}"/>">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
