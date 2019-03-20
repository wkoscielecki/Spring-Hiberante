<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2> Publisher </h2>

<a href="${pageContext.request.contextPath}/publisher/list">Back to list</a>

<form:form modelAttribute="publisher" method="post">

    <form:input path="name" placeholder="name"/>
    <form:errors path="name" element="div"/>
    <form:input path="nip" placeholder="nip"/>
    <form:errors path="nip" element="div"/>
    <form:input path="regon" placeholder="regon"/>
    <form:errors path="regon" element="div"/>


    <input type="submit">
</form:form>

</body>
</html>
