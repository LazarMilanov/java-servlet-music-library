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

@WebServlet("/SaveArtistServlet")
public class SaveArtistServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArtistHibernate newArtist = new ArtistHibernate();
        newArtist.setName(name);
        ArtistHibernateDAO.saveArtist(newArtist);
        String message = "Successfully added a new artist";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewArtistServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ArtistHibernate> listArtists = ArtistHibernateDAO.getAllArtists();
        request.setAttribute("listArtists", listArtists);
        request.getRequestDispatcher("artist-form.jsp").forward(request, response);
    }

}
