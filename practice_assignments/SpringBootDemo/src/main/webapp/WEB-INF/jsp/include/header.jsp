<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Per Scholas Spring Demo</title>


</head>
<body>
<table>
    <tr>
<%--        only displays login link if not currently logged in to an account--%>
        <sec:authorize access="!isAuthenticated()">
            <td><a href="/login/login">Login</a></td>
        </sec:authorize>
<%--        logout url is from spring security--%>
<%--        only displays logout button if user is logged in--%>
        <sec:authorize access="isAuthenticated()">
            <td><a href="/login/logout">Logout</a></td>
        </sec:authorize>

        <td><a href="/registration-url-path/register">User Registration</a></td>
        <td><a href="/index">Home</a></td>
        <td><a href="/registration-url-path/userList">User Search</a></td>
        <td><a href="/user/profile">User Profile</a></td>

<%--        only displays admin home button if logged in as a user with admin role--%>
<%--        learn more about security tags here: https://www.baeldung.com/spring-security-taglibs--%>
        <sec:authorize access="hasAuthority('ADMIN')">
            <td><a href="/admin/home">Admin Home</a></td>
        </sec:authorize>
    </tr>
</table>
<hr>
<div class="container">