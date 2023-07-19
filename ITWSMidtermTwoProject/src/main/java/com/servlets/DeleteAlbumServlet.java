package com.servlets;

import com.example.AlbumHibernateDAO;
import com.example.ArtistHibernateDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAlbumServlet")
public class DeleteAlbumServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        AlbumHibernateDAO.deleteAlbum(id);
        String message = "Successfully deleted album";
        request.getSession().setAttribute("message", message);
        request.getSession().setAttribute("messagetype", "success");
        response.sendRedirect("ViewAlbumervlet");

    }
}
