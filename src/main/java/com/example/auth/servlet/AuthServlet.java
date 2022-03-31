package com.example.auth.servlet;

import com.example.auth.service.AuthService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "auth", value = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean isAuth = AuthService.checkAuth(login, password);

        if (isAuth) {
            // перенаправить на страницу с товарами
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/items");
            requestDispatcher.forward(req, resp);
        } else {
            // показать туже страницу с логином и паролем только добавить поле с ошибочными данными
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            req.setAttribute("errorMessage", "Неправильный логин или пароль!");

            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }

}