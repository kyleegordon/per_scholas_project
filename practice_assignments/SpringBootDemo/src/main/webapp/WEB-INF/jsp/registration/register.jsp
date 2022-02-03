<!--    this is required to use JSTL on a jsp page-->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<form method="GET"  action="/registration-url-path/registerSubmit" >

    <table>
<%--        below input is invisible, but stores a value that can be accessed by the backend to distinguish an update from a create--%>
        <input type="hidden" name="id" value="${formBeanKey.id}">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" value="${formBeanKey.username}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${formBeanKey.email}"></td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" value="${formBeanKey.firstName}"></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName" value="${formBeanKey.lastName}"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="${formBeanKey.password}"></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirmPassword" value="${formBeanKey.confirmPassword}"></td>
        </tr>

    </table>


    <button type="submit">Submit</button>
</form>

<div style="color: red;">
<!--    this is a JSTL for loop-->
    <c:forEach var = "message" items = "${formBeanKey.errorMessages}" >
    <p><c:out value = "${message}"/><p>
    </c:forEach>
</div>

<jsp:include page="../include/footer.jsp" />