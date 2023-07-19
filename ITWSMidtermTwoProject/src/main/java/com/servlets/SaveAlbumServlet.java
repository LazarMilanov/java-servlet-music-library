package com.servlets;

import com.example.AlbumHibernate;
import com.example.AlbumHibernateDAO;
import com.example.ArtistHibernate;
import com.example.ArtistHibernateDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SaveAlbumServlet")
public class SaveAlbumServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int artistid = Integer.parseInt(request.getParameter("artist"));
        ArtistHibernate artist = ArtistHibernateDAO.getArtist(artistid);
        AlbumHibernate newAlbum = new AlbumHibernate();
        newAlbum.setTitle(title);
        newAlbum.setArtist(artist);
        AlbumHibernateDAO.saveAlbum(newAlbum);
        String message = "Successfully added a new album";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewAlbumServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArtistHibernate> listArtists = ArtistHibernateDAO.getAllArtists();
        request.setAttribute("listArtists", listArtists);
        request.getRequestDispatcher("album-form.jsp").forward(request, response);

    }


}
