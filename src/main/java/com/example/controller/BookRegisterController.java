package com.example.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 책등록 JSP로 forward
        // 객체바인딩은 필요 없다
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
        rd.forward(req, resp);
    }
}
