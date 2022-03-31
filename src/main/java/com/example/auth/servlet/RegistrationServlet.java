package com.example.auth.servlet;

import com.example.auth.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean isRegistered = RegistrationService.register(login, password);

        if (!isRegistered) {
            req.setAttribute("errorMessage", "Проблемы при регистрации!");
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
