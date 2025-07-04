<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.entities.Employe,java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .actions a {
            margin-right: 10px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h1>Employee List</h1>
    <a href="<%= request.getContextPath() %>/employes/new">Add New Employee</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Employe> employes = (List<Employe>) request.getAttribute("employes");
                if (employes != null) {
                    for (Employe employe : employes) {
            %>
            <tr>
                <td><%= employe.getId() %></td>
                <td><%= employe.getName() %></td>
                <td class="actions">
                    <a href="<%= request.getContextPath() %>/employes/edit/<%= employe.getId() %>">Edit</a>
                    <a href="<%= request.getContextPath() %>/employes/delete/<%= employe.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/">Back to Home</a>
</body>
</html>