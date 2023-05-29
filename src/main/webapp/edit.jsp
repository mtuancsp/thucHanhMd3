<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29/05/2023
  Time: 9:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>
    <a href="listEmployee">List of employee</a>
</h2>
<p class="message" style="text-align: center; color: green; font-size: 25px;">
    <span>${message}</span>
</p>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <h2>
                Edit User
            </h2>
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="name" size="40"
                           value="${employee.name}"
                    />
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="email" size="40"
                           value="${employee.email}"
                    />
                </td>
            </tr>
            <tr>
                <th>Adrress</th>
                <td>
                    <input type="text" name="address" size="40"
                           value="${employee.address}"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>
                    <input type="text" name="phone" size="40"
                           value="${employee.phone}"
                    />
                </td>
            </tr>
            <tr>
                <th>Salary</th>
                <td>
                    <input type="text" name="salary" size="40"
                           value="${employee.salary}"
                    />
                </td>
            </tr>
            <tr>
                <th>Department ID</th>
                <td>
                    <input type="text" name="department_id" size="40"
                           value="${employee.department_id}"
                    />
                </td>
            </tr>
            <tr>
                <th>Department</th>
                <td>
                    <input type="text" name="department" size="40"
                           value="${employee.department}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" onclick="return confirm('Are you sure you want to save?')"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
