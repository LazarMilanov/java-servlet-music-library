<%--
  Created by IntelliJ IDEA.
  User: lazar
  Date: 16-Mar-22
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Track form</title>
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

        <c:if test="${sessionScope.message != null}">

            <div class="alert alert-${sessionScope.messagetype} alert-dismissible fade show" role="alert">
                <span>${sessionScope.message}</span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <c:remove var="message" scope="session" /><c:remove var="messagetype" scope="session" />
        </c:if>

        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${requestScope.track != null}">
                    <form action="EditTrackServlet" method="post">
                        </c:if>
                        <c:if test="${requestScope.track == null}">
                        <form action="SaveTrackServlet" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${requestScope.track != null}">
                                        Edit Track
                                    </c:if>
                                    <c:if test="${requestScope.track == null}">
                                        Add New Track
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${requestScope.track != null}">
                                <input type="hidden" name="id" value="<c:out value='${requestScope.track.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Track title</label>
                                <input type="text" value="<c:out value='${requestScope.track.title}' />" class="form-control" name="title" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Length</label>
                                <input type="text" value="<c:out value='${requestScope.track.length}' />" class="form-control" name="length" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Price</label>
                                <input type="text" value="<c:out value='${requestScope.track.price}' />" class="form-control" name="price" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Album</label>
                                <select name="album" class="form-control" required="required">
                                    <c:if test="${requestScope.track != null}">
                                        <option value="" disabled>Select an album</option>
                                        <c:forEach var="album" items="${requestScope.listAlbums}">
                                            <c:choose>
                                                <c:when test="${album.id == requestScope.track.album.id}">
                                                    <option value="${album.id}" selected>${album.artist.name} - ${album.title}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${album.id}">${album.artist.name} - ${album.title}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${requestScope.track == null}">
                                        <option value="" disabled selected>Select an album</option>
                                        <c:forEach var="album" items="${requestScope.listAlbums}">
                                            <option value="${album.id}">${album.artist.name} - ${album.title}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>
                            </fieldset>

                            <button type="submit" class="btn btn-success">Save</button>

                        </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
