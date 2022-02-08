
<jsp:include page="../include/header.jsp" />

<h1> File Upload Example</h1>

<form method="POST" action="" enctype="multipart/form-data">

    <table>
        <tr>
            <td>Title: </td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>Select File: </td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>



</form>



<jsp:include page="../include/footer.jsp" />