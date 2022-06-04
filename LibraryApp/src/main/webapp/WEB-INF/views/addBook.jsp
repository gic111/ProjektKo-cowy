<%--
  Created by IntelliJ IDEA.
  User: gic111
  Date: 25.05.2022
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AddBook</title>
</head>
<body>

<form:form  modelAttribute="book">
    ISBN: <form:input path="isbn"/>
    TITLE:<form:input path="title"/>
    AUTHOR:<form:input path="author"/>
    PUBLISHER:<form:input path="publisher"/>
    DESCRIPTION:<form:textarea path="description" rows="3" cols="15"/>
    QUANTITY: <form:input path="quantity"/>
    CATEGORY:
    <form:select itemValue="id" itemLabel="name" path="category"
                 items="${categories}" />


    <input type="submit" value="save">
</form:form>
</body>
</html>
