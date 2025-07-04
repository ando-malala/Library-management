<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.entities.Film" %>
<%@ page import="com.example.entities.CategorieFilm" %>
<!DOCTYPE html>
<html>
<head>
    <title>Films List</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 1200px; margin: 0 auto; }
        .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        .btn { padding: 10px 15px; text-decoration: none; border-radius: 5px; border: none; cursor: pointer; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-success { background-color: #28a745; color: white; }
        .btn-warning { background-color: #ffc107; color: black; }
        .btn-danger { background-color: #dc3545; color: white; }
        .btn:hover { opacity: 0.8; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f8f9fa; }
        .search-form { margin-bottom: 20px; }
        .search-form input { padding: 8px; margin-right: 10px; }
        .alert { padding: 15px; margin-bottom: 20px; border-radius: 5px; }
        .alert-success { background-color: #d4edda; color: #155724; border: 1px solid #c3e6cb; }
        .alert-danger { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
        .categories { font-size: 12px; color: #666; }
        .no-data { text-align: center; padding: 40px; color: #666; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Films Management</h1>
            <a href="${pageContext.request.contextPath}/films/new" class="btn btn-success">Add New Film</a>
        </div>

        <% 
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (successMessage != null) { 
        %>
            <div class="alert alert-success"><%= successMessage %></div>
        <% } %>
        <% if (errorMessage != null) { %>
            <div class="alert alert-danger"><%= errorMessage %></div>
        <% } %>

        <form class="search-form" method="get">
            <input type="text" name="search" placeholder="Search films by name..." 
                   value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>">
            <button type="submit" class="btn btn-primary">Search</button>
            <% if (request.getParameter("search") != null) { %>
                <a href="${pageContext.request.contextPath}/films" class="btn btn-warning">Clear</a>
            <% } %>
        </form>

        <%
        List<Film> films = (List<Film>) request.getAttribute("films");
        if (films != null && !films.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Categories</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (Film film : films) { %>
                <tr>
                    <td><%= film.getId() %></td>
                    <td><%= film.getNom() %></td>
                    <td><%= film.getTypeFilm() != null ? film.getTypeFilm().getNom() : "N/A" %></td>
                    <td class="categories">
                        <%
                        if (film.getCategorieFilms() != null && !film.getCategorieFilms().isEmpty()) {
                            StringBuilder categories = new StringBuilder();
                            for (int i = 0; i < film.getCategorieFilms().size(); i++) {
                                CategorieFilm cf = film.getCategorieFilms().get(i);
                                if (cf.getCategorie() != null) {
                                    categories.append(cf.getCategorie().getNom());
                                    if (i < film.getCategorieFilms().size() - 1) {
                                        categories.append(", ");
                                    }
                                }
                            }
                            out.print(categories.toString());
                        } else {
                            out.print("No categories");
                        }
                        %>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/films/<%= film.getId() %>" class="btn btn-primary">View</a>
                        <a href="${pageContext.request.contextPath}/films/<%= film.getId() %>/edit" class="btn btn-warning">Edit</a>
                        <form style="display: inline;" method="post" action="${pageContext.request.contextPath}/films/<%= film.getId() %>/delete"
                              onsubmit="return confirm('Are you sure you want to delete this film?');">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <div class="no-data">
            <p>No films found.</p>
            <% if (request.getParameter("search") != null) { %>
                <p>Try a different search term or <a href="${pageContext.request.contextPath}/films">view all films</a>.</p>
            <% } %>
        </div>
        <% } %>
    </div>
</body>
</html>