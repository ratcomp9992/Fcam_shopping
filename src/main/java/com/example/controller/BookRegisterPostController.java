package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerPost")
public class BookRegisterPostController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // register.jsp 에서 받아온 값들(title, price, name, page)을 DB에 저장한다.
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String name = req.getParameter("name");
        int page = Integer.parseInt(req.getParameter("page"));

        // DTO로 묶어서 DAO로 전송
        BookDTO dto = new BookDTO();
        dto.setTitle(title);
        dto.setPrice(price);
        dto.setName(name);
        dto.setPage(page);

        BookDAO dao = new BookDAO();
        dao.bookInsert(dto);

        // 저장 후에 다시 List 보기로 이동 해야 한다.
        // redirect : controller -> controller
        resp.sendRedirect("list");  // http://localhost:8081/shopping/list

    }
}