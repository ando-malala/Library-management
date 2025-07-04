<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.entities.Film" %>
<%@ page import="com.example.entities.TypeFilm" %>
<%@ page import="com.example.entities.Categorie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Film</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], select { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; }
        .checkbox-group { display: flex; flex-wrap: wrap; gap: 15px; margin-top: 10px; }
        .checkbox-item { display: flex; align-items: center; }
        .checkbox-item input[type="checkbox"] { margin-right: 8px; }
        .btn { padding: 12px 20px; text-decoration: none; border-radius: 5px; border: none; cursor: pointer; margin-right: 10px; }
        .btn-success { background-color: #28a745; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .btn:hover { opacity: 0.8; }
        .header { margin-bottom: 30px; }
        .alert { padding: 15px; margin-bottom: 20px; border-radius: 5px; }
        .alert-danger { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Add New Film</h1>
        </div>

        <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) { 
        %>
            <div class="alert alert-danger"><%= errorMessage %></div>
        <% } %>

        <form method="post" action="${pageContext.request.contextPath}/films">
            <div class="form-group">
                <label for="nom">Film Name:</label>
                <input type="text" id="nom" name="nom" required>
            </div>

            <div class="form-group">
                <label for="typeFilm">Film Type:</label>
                <select id="typeFilm" name="typeFilm.id" required>
                    <option value="">Select a type...</option>
                    <%
                    List<TypeFilm> typeFilms = (List<TypeFilm>) request.getAttribute("typeFilms");
                    if (typeFilms != null) {
                        for (TypeFilm type : typeFilms) {
                    %>
                        <option value="<%= type.getId() %>"><%= type.getNom() %></option>
                    <% 
                        }
                    }
                    %>
                </select>
            </div>

            <div class="form-group">
                <label>Categories:</label>
                <div class="checkbox-group">
                    <%
                    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
                    if (categories != null) {
                        for (Categorie categorie : categories) {
                    %>
                        <div class="checkbox-item">
                            <input type="checkbox" id="cat_<%= categorie.getId() %>" 
                                   name="categorieIds" value="<%= categorie.getId() %>">
                            <label for="cat_<%= categorie.getId() %>"><%= categorie.getNom() %></label>
                        </div>
                    <% 
                        }
                    }
                    %>
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">Create Film</button>
                <a href="${pageContext.request.contextPath}/films" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>