<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        form input,select{
            display:block;
            margin: 15px 0;
        }

    </style>
</head>
<body>

<h2>Book Form</h2>
<a href="${pageContext.request.contextPath}/book/list">Back to list</a>

<form:form modelAttribute="book" method="post">
    <%--<form:hidden path="id"/>--%>
    Title: <form:input path="title" placeholder="Title"/>
    Rating: <form:input path="rating" placeholder="Rating"/>
    Authors:<form:select path="authors" multiple="true" >
        <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
    </form:select>
    Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>

    <input type="submit" value="Save">


</form:form>

</body>
</html>
