package com.servlets;

import com.example.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EditAlbumServlet")
public class EditAlbumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int artistid = Integer.parseInt(request.getParameter("artist"));

        ArtistHibernate artist = ArtistHibernateDAO.getArtist(artistid);
        AlbumHibernate album = AlbumHibernateDAO.getAlbum(id);
        album.setTitle(title);
        album.setArtist(artist);

        AlbumHibernateDAO.updateAlbum(album);

        String message = "Successfully edited album";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewAlbumServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        AlbumHibernate album = AlbumHibernateDAO.getAlbum(id);
        List<ArtistHibernate> listArtists = ArtistHibernateDAO.getAllArtists();
        request.setAttribute("album", album);
        request.setAttribute("listArtists", listArtists);
        request.getRequestDispatcher("album-form.jsp").forward(request, response);

    }
}
