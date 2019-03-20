<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 20.03.19
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="book" method="post">
    <%--<form:hidden path="id"/>--%>
    Title: <form:input path="title" placeholder="Title"/>
    <form:errors path="title" element="div"/>
    Description: <form:input path="description" placeholder="Description"/>
    <form:errors path="description" element="div"/>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
