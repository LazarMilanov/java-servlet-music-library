package com.servlets;

import com.example.ArtistHibernate;
import com.example.ArtistHibernateDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ViewArtistServlet", urlPatterns={"/ViewArtistServlet", "/"})
public class ViewArtistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArtistHibernate> listArtists = ArtistHibernateDAO.getAllArtists();
        request.setAttribute("listArtists", listArtists);
        request.getRequestDispatcher("list-artist.jsp").forward(request, response);

    }
}
