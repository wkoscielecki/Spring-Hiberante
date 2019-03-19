<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.03.19
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<h2>Student form</h2>

<form:form modelAttribute="student" method="post">

    <div cssClass="form-group">
        <label>First Name:
            <form:input cssClass="form-control" path="firstName" placeholder="firstName"/>
        </label>
        <label>Last Name:
            <form:input cssClass="form-control" path="lastName" placeholder="LastName"/>
        </label>
    </div>
    <div cssClass="custom-control custom-radio">
        <Label>Select Gender:
            M <form:radiobutton path="gender" value="M"/>
            K <form:radiobutton path="gender" value="K"/>
        </Label>
    </div>
    <div>
        <label>Select Country
            <form:select path="country" items="${countries}"/>
        </label>
    </div>
    <div>
        <label>Notes
            <form:textarea path="notes" placeholder="Insert your notes"/>
        </label>
    </div>
    <div>
        <label>Mail agreement:
            <form:checkbox path="mailingList"/>
        </label>
    </div>
    <label> Programming Skills:
        <form:select cssClass="form-control" path="programmingSkills" items="${skills}" multiple="true"/>
    </label>
    <div>
        <label>Hobbies:
            <form:checkboxes items="${hobbieItems}" path="hobbies"/>
        </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>

</body>

</html>
