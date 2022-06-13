<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 30.05.2022
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Hello World</h3>

<a href="<c:url value="/books/all"/>">Books</a>
<a href="<c:url value="/users/all"/>">Users</a>
<a href="<c:url value="/categories/all"/>">Categories</a>
<a href="<c:url value="/lend/all"/>">Lendings</a>
</body>
</html>
