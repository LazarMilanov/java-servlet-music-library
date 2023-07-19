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

@WebServlet("/ViewTrackServlet")
public class ViewTrackServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TrackHibernate> listTracks = new ArrayList<>();

        if (request.getParameter("albumid") != null) {
            int id = Integer.parseInt(request.getParameter("albumid"));
            listTracks = AlbumHibernateDAO.getAlbum(id).getTracks();
        }
        else if (request.getParameter("artistid") != null) {
            int id = Integer.parseInt(request.getParameter("artistid"));
            listTracks = TrackHibernateDAO.getTracksByArtist(id);
        } else {
            listTracks = TrackHibernateDAO.getAllTracks();
        }
        request.setAttribute("listTracks", listTracks);
        request.getRequestDispatcher("list-track.jsp").forward(request, response);

    }
}
