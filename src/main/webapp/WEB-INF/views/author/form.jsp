<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Author Form</h2>
<a href="${pageContext.request.contextPath}/author/list">Back to list</a>

<form:form modelAttribute="author" method="post">
    <form:input path="firstName" placeholder="First Name"/>
    <form:errors path="firstName" element="div"/>
    <form:input path="lastName" placeholder="Last Name"/>
    <form:errors path="lastName" element="div"/>
    <form:input path="yearOfBirth" placeholder="Year of birth" value="${author.yearOfBirth}"/>
    <form:errors path="yearOfBirth" element="div"/>
    <form:input path="email" placeholder="Enter email"/>
    <form:errors path="email" element="div"/>
<form:input path="pesel" placeholder="Enter pesel"/>
    <form:errors path="pesel" element="div"/>

    <input type="submit" value="Save">

</form:form>


</body>
</html>
