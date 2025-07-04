<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.entities.Film" %>
<%@ page import="com.example.entities.CategorieFilm" %>
<!DOCTYPE html>
<html>
<head>
    <title>Film Details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        .header { margin-bottom: 30px; }
        .detail-card { background-color: #f8f9fa; padding: 20px; border-radius: 8px; margin-bottom: 20px; }
        .detail-row { margin-bottom: 15px; }
        .detail-label { font-weight: bold; color: #495057; margin-bottom: 5px; }
        .detail-value { color: #212529; }
        .categories { display: flex; flex-wrap: wrap; gap: 8px; }
        .category-tag { background-color: #007bff; color: white; padding: 4px 8px; border-radius: 12px; font-size: 12px; }
        .btn { padding: 10px 15px; text-decoration: none; border-radius: 5px; border: none; cursor: pointer; margin-right: 10px; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-warning { background-color: #ffc107; color: black; }
        .btn-danger { background-color: #dc3545; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .btn:hover { opacity: 0.8; }
        .actions { margin-top: 30px; }
        .back-link { display: inline-block; margin-bottom: 20px; color: #007bff; text-decoration: none; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="container">
        <%
        Film film = (Film) request.getAttribute("film");
        if (film == null) {
            response.sendRedirect(request.getContextPath() + "/films");
            return;
        }
        %>
        
        <a href="${pageContext.request.contextPath}/films" class="back-link">← Back to Films List</a>
        
        <div class="header">
            <h1>Film Details</h1>
        </div>

        <div class="detail-card">
            <div class="detail-row">
                <div class="detail-label">ID:</div>
                <div class="detail-value"><%= film.getId() %></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label">Name:</div>
                <div class="detail-value"><%= film.getNom() %></div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label">Type:</div>
                <div class="detail-value">
                    <%= film.getTypeFilm() != null ? film.getTypeFilm().getNom() : "No type assigned" %>
                </div>
            </div>
            
            <div class="detail-row">
                <div class="detail-label">Categories:</div>
                <div class="detail-value">
                    <%
                    if (film.getCategorieFilms() != null && !film.getCategorieFilms().isEmpty()) {
                    %>
                        <div class="categories">
                            <%
                            for (CategorieFilm cf : film.getCategorieFilms()) {
                                if (cf.getCategorie() != null) {
                            %>
                                <span class="category-tag"><%= cf.getCategorie().getNom() %></span>
                            <%
                                }
                            }
                            %>
                        </div>
                    <%
                    } else {
                    %>
                        <span style="color: #6c757d; font-style: italic;">No categories assigned</span>
                    <%
                    }
                    %>
                </div>
            </div>
        </div>

        <div class="actions">
            <a href="${pageContext.request.contextPath}/films/<%= film.getId() %>/edit" class="btn btn-warning">Edit Film</a>
            <form style="display: inline;" method="post" action="${pageContext.request.contextPath}/films/<%= film.getId() %>/delete"
                  onsubmit="return confirm('Are you sure you want to delete this film? This action cannot be undone.');">
                <button type="submit" class="btn btn-danger">Delete Film</button>
            </form>
            <a href="${pageContext.request.contextPath}/films" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
</body>
</html>