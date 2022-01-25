<html>

<body>
<h1>User Registration</h1>
<table>
    <form method="GET" action="/indexSubmit">
        <tr>
            <td>
                <label for="company_name">Company Name</label>
            </td>
            <td>
                <input type="text" id="company_name" name="company_name" required />
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">Contact Email</label>
            </td>
            <td>
                <input type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password</label>
            </td>
            <td>
                <input type="password" id="password" name="password" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="phone">Contact Phone #</label>
            </td>
            <td>
                <input type="tel" id="phone" name="phone" placeholder="555-555-5555" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="website">Website URL</label>
            </td>
            <td>
                <input type="text" id="website" name="website" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="employees">Number of Employees</label>
            </td>
            <td>
                <input type="number" id="employees" name="employees" min="1"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="industry">Industry</label>
            </td>
            <td>
                <input type="text" id="industry" name="industry" />
            </td>
        </tr>
        <tr>
            <td>
                <label for="security_professionals">Do you employ security professionals</label>
            </td>
            <td>
                <input type="radio" id="yes" name="security_professionals" value="yes">
                <label for="yes">Yes</label>
                <input type="radio" id="no" name="security_professionals" value="no" checked>
                <label for="no">No</label>
            </td>
        </tr>
        <tr>
            <td>
                <label for="data_types">Data Types Managed</label>
            </td>
            <td>
                <input type="checkbox" id="data1" name="data_types" value="Personal">
                <label for="data1">Personal</label>
                <br>
                <input type="checkbox" id="data2" name="data_types" value="Healthcare">
                <label for="data2">Healthcare</label>
                <br>
                <input type="checkbox" id="data3" name="data_types" value="Credit">
                <label for="data3">Credit Card</label>
                <br>
                <input type="checkbox" id="data4" name="data_types" value="Other">
                <label for="data4">Other</label>
            </td>
        </tr>
        <tr style="text-align: center;">
            <td colspan="2">
                <input type="submit" value="Submit">
            </td>
        </tr>
    </form>
</table>
</body>

</html>