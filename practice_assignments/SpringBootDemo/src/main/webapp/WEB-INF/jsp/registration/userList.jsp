<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<style>
    #searchResults td {
        padding: 5px;
        border: solid black 1px;

    }
</style>
<form action="/registration-url-path/userList">
    <input type="text" name="search">
    <button type="submit">Search</button>
</form>
<table id="searchResults" style="border-collapse: collapse;">
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Email</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Password</td>
    </tr>

    <c:forEach items = "${userListKey}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />