package com.servlets;

import com.example.AlbumHibernate;
import com.example.ArtistHibernate;
import com.example.ArtistHibernateDAO;
import com.example.TrackHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EditArtistServlet")
public class EditArtistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        ArtistHibernate artist = ArtistHibernateDAO.getArtist(id);
        artist.setName(name);
        ArtistHibernateDAO.updateArtist(artist);
        String message = "Successfully edited artist";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewArtistServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ArtistHibernate artist = ArtistHibernateDAO.getArtist(id);
        List<ArtistHibernate> listArtists = ArtistHibernateDAO.getAllArtists();
        request.setAttribute("listArtists", listArtists);
        request.setAttribute("artist", artist);
        request.getRequestDispatcher("artist-form.jsp").forward(request, response);

    }
}
