package com.example.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

//@WebServlet("/")
public class TemplateController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청을 받은 Controller가 어떻게 View로 이동을 시켜줄까?
        // Controller와 View를 연동해야한다. (forward)
        // Controller가 View로 데이터(Object + DTO, List<DTO> 등)을 보내야 한다. => 객체 바인딩(Object Binding)
        /*
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(req, resp);  // View도 client에 대한 정보를 알고 있어야 하기 때문에 req, resp를 매개변수로 받는다.
        */
    }
}
