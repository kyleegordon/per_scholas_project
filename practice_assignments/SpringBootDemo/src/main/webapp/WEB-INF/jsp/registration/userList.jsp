<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<style>
    #searchResults td {
        padding: 5px;
        border: solid black 1px;

    }
</style>

<form action="/registration-url-path/userList">
    <input type="text" name="search" value="${searchFormValue}">
    <button type="submit">Search By First Name</button>
</form>
<hr>

<form action="/registration-url-path/userList">
    First Name: <input type="text" name="firstName" value="${firstNameForm1}">
    Last Name: <input type="text" name="lastName" value="${lastNameForm1}">
    <button type="submit">Search By First Or Last Name</button>
</form>

<form action="/registration-url-path/userListResult">
    First Name: <input type="text" name="firstName" value="${firstNameForm2}">
    Last Name: <input type="text" name="lastName" value="${lastNameForm2}">
    <button type="submit">Search By First And Last Name</button>
</form>

<table id="searchResults" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Email</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Password</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach items = "${userListKey}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
            <td><a href="/registration-url-path/register?id=${user.id}">Edit</a></td>
            <td><a href="/registration-url-path/deleteUser?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />