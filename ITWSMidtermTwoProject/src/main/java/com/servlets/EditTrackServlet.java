package com.servlets;

import com.example.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EditTrackServlet")
public class EditTrackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String length = request.getParameter("length");
        String price = request.getParameter("price");
        int albumid = Integer.parseInt(request.getParameter("album"));
        AlbumHibernate album = AlbumHibernateDAO.getAlbum(albumid);
        TrackHibernate track = TrackHibernateDAO.getTrack(id);
        track.setTitle(title);
        track.setLength(length);
        track.setPrice(price);
        track.setAlbum(album);
        TrackHibernateDAO.updateTrack(track);
        String message = "Successfully edited track";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewTrackServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        TrackHibernate track = TrackHibernateDAO.getTrack(id);
        List<AlbumHibernate> listAlbums = AlbumHibernateDAO.getAllAlbums();
        request.setAttribute("track", track);
        request.setAttribute("listAlbums", listAlbums);
        request.getRequestDispatcher("track-form.jsp").forward(request, response);

    }
}
