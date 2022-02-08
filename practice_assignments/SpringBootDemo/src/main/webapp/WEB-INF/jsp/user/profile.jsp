<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp" />

<h1> This is the user profile page</h1>
<%--this allows you to display user info from the database--%>
<h2>The logged in user is: <sec:authentication property="principal.username"></sec:authentication></h2>


<jsp:include page="../include/footer.jsp" />