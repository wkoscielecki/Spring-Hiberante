<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        form input, select {
            display: block;
            margin: 15px 0;
        }

    </style>
</head>
<body>

<h2>Book Form</h2>
<a href="${pageContext.request.contextPath}/book/list">Back to list</a>


<%--<c:if test="${not empty errors}">--%>
<%--<ul>--%>
<%--<c:forEach items="${errors}" var="err">--%>
<%--<li>${err.propertyPath} : ${err.message}</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</c:if>--%>


<form:form modelAttribute="book" method="post">
    <%--<form:hidden path="id"/>--%>
    Title: <form:input path="title" placeholder="Title"/>
    <form:errors path="title" element="div"/>
    Rating: <form:input path="rating" placeholder="Rating"/>
    <form:errors path="rating" element="div"/>
    Description: <form:input path="description" placeholder="Description"/>
    <form:errors path="description" element="div"/>
    Authors:<form:select path="authors" multiple="true">
    <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
</form:select>
    <form:errors path="authors" element="div"/>
    Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <form:errors path="publisher" element="div"/>
    Category: <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
    <form:errors path="category" element="div"/>

    <input type="submit" value="Save">

</form:form>

</body>
</html>
