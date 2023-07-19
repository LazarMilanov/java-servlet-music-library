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

@WebServlet("/ViewAlbumServlet")
public class ViewAlbumServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<AlbumHibernate> listAlbums;

        if (request.getParameter("artistid") != null) {
            int id = Integer.parseInt(request.getParameter("artistid"));
            listAlbums = ArtistHibernateDAO.getArtist(id).getAlbums();
        } else {
            listAlbums = AlbumHibernateDAO.getAllAlbums();
        }
        request.setAttribute("listAlbums", listAlbums);
        request.getRequestDispatcher("list-album.jsp").forward(request, response);
    }
}
