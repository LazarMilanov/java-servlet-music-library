package com.servlets;

import com.example.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SaveTrackServlet")
public class SaveTrackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String length = request.getParameter("length");
        String price = request.getParameter("price");
        int albumid = Integer.parseInt(request.getParameter("album"));
        AlbumHibernate album = AlbumHibernateDAO.getAlbum(albumid);
        TrackHibernate newTrack = new TrackHibernate();
        newTrack.setTitle(title);
        newTrack.setLength(length);
        newTrack.setPrice(price);
        newTrack.setAlbum(album);
        TrackHibernateDAO.saveTrack(newTrack);
        String message = "Successfully added a new track";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewTrackServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AlbumHibernate> listAlbums = AlbumHibernateDAO.getAllAlbums();
        request.setAttribute("listAlbums", listAlbums);
        request.getRequestDispatcher("track-form.jsp").forward(request, response);
    }
}
