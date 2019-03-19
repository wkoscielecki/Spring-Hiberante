<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Person form</h2>
<form:form modelAttribute="person" method="post">

    <form:input path="login" placeholder="login"/>
    <form:password path="password" placeholder="password"/>
    <form:input path="email" placeholder="email"/>
    <input type="submit">

</form:form>


</body>
</html>
