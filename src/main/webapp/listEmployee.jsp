<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29/05/2023
  Time: 9:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        body {
            text-align: center;
        }

        .btn {
            background-color: #f2f2f2;
            border: 1px solid #ccc;
            text-decoration: none;
            padding: 1px 2px 1px 2px;
        }
        .edit {
            color: blue;
        }
        .edit:hover {
            background-color: blue;
            color: white;
            cursor: pointer;
        }
        .delete {
            color: red;
            font-size: 16px;
            font-family: "Times New Roman", serif;
        }
        .delete:hover {
            background-color: red;
            color: white;
            cursor: pointer;
        }
        td {
            padding: 3px;
        }

    </style>
</head>
<body>
<h1>User Management</h1>
<div>
    <h2><a href="create.jsp">Add New User</a></h2>
    <form method="post">
        <input type="text" id="search" name="search" value="${search}" placeholder="Keyword" oninput="submit()">
        <input type="submit" value="Search">
    </form>
    <p class="message" style="text-align: center; color: green">
        <span>${message}</span>
    </p>
    <table border="1" cellpadding="5" align="center">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Salary</th>
            <th>Department</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.phone}</td>
                <td>${employee.salary}</td>
                <td>${employee.department}</td>
                <td>
                    <a class="btn edit" href="/edit?id=${employee.id}">Edit</a>
                </td>
                <td>
                    <a class="btn delete" href="/delete?id=${employee.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    window.onload = function () {
        let input = document.getElementById('search');
        input.focus();
        input.setSelectionRange(input.value.length, input.value.length);
    }
</script>
</body>
</html>
