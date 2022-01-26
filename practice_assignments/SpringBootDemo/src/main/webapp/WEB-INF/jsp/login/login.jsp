<html>

<body>

<table>
    <form method="GET" action="/loginSubmit">
        <tr>
            <td>
                <label for="username">Username: </label>
            </td>
            <td>
                <input type="text" id="username" name="username" required />
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password: </label>
            </td>
            <td>
                <input type="password" id="password" name="password" required/>
            </td>
        </tr>
        <tr style="text-align: center;">
            <td colspan="2">
                <input type="submit" value="Submit">
            </td>
        </tr>
    </form>
    <p>Username: ${username}</p>
    <p>Password: ${password}</p>
</table>
</body>
</html>