<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="iso-8859-1"%>
<html>
<head>
    <title>Per Scholas Spring Demo</title>


</head>
<body>
<table>
    <tr>
        <td><a href="/login/login">Login</a></td>
<%--        logout url is from spring security--%>
        <td><a href="/login/logout">Logout</a></td>
        <td><a href="/registration-url-path/register">User Registration</a></td>
        <td><a href="/index">Home</a></td>
        <td><a href="/registration-url-path/userList">User Search</a></td>
        <td><a href="/admin/home">Admin Home</a></td>
    </tr>
</table>
<hr>
<div class="container">