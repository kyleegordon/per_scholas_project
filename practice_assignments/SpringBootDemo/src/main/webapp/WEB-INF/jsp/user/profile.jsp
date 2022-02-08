<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />

<h1> This is the user profile page</h1>
<%--this allows you to display user info from the database--%>
<%--more info can be found here https://www.baeldung.com/spring-security-taglibs--%>
<h2>The logged in user is: <sec:authentication property="principal.username"></sec:authentication></h2>
<ul>
    <li>ID: ${userProfile.id}</li>
    <li>Email: ${userProfile.email}</li>
    <li>First Name: ${userProfile.firstName}</li>
    <li>Last Name: ${userProfile.lastName}</li>
</ul>


<jsp:include page="../include/footer.jsp" />