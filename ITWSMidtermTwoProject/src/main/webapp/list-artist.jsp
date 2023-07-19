<%--
  Created by IntelliJ IDEA.
  User: lazar
  Date: 16-Mar-22
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Artist list</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="style.css"%></style>
</head>
<body>
<header class="site-header">
    <nav class="navbar navbar-expand-md navbar-dark bg-steel">
        <div>
            <a href="<%=request.getContextPath()%>/ViewArtistServlet" class="navbar-brand">Music Archive</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/ViewArtistServlet" class="nav-link">Artists</a></li>
            <li><a href="<%=request.getContextPath()%>/ViewAlbumServlet" class="nav-link">Albums</a></li>
            <li><a href="<%=request.getContextPath()%>/ViewTrackServlet" class="nav-link">Tracks</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <div class="container">
        <h3 class="text-center">List of Artists</h3>
        <hr>
        <c:if test="${sessionScope.message != null}">

            <div class="alert alert-${sessionScope.messagetype} alert-dismissible fade show" role="alert">
                <span>${sessionScope.message}</span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <c:remove var="message" scope="session" /><c:remove var="messagetype" scope="session" />
        </c:if>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/SaveArtistServlet" class="btn btn-success">Add New Artist</a>
        </div>
        <br>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Name</th>
                <th></th>
                <th></th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="artist" items="${requestScope.listArtists}">
                <tr>
                    <td>
                        <c:out value="${artist.name}"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/ViewAlbumServlet?artistid=<c:out value="${artist.id}"/>">View Albums</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/ViewTrackServlet?artistid=<c:out value="${artist.id}"/>">View Tracks</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/EditArtistServlet?id=<c:out value="${artist.id}"/>">Edit</a> &nbsp <a href="${pageContext.request.contextPath}/DeleteArtistServlet?id=<c:out value="${artist.id}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
