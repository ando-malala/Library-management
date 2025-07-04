<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.entities.Employe" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        .form-container {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <%
            Employe employe = (Employe) request.getAttribute("employe");
            String formAction = employe != null && employe.getId() > 0 ?
                request.getContextPath() + "/employes/edit/" + employe.getId() :
                request.getContextPath() + "/employes";
            String formTitle = employe != null && employe.getId() > 0 ? "Edit Employee" : "Add Employee";
            String nameValue = employe != null && employe.getName() != null ? employe.getName() : "";
        %>
        <h1><%= formTitle %></h1>
        <form action="<%= formAction %>" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<%= nameValue %>" required />
            </div>
            <input type="submit" value="Save" />
        </form>
        <a href="<%= request.getContextPath() %>/employes">Back to Employee List</a>
    </div>
</body>
</html>