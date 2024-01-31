package com.example.controller;

import com.example.entity.BoardDTO;
import com.example.entity.BookDTO;
import com.example.repository.BookDAO;
import com.example.repository.BookMyBatisDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@WebServlet("/list")
public class BookListController implements Controller {
    public String requestHandler (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // DB에서 데이터를 꺼내옴
        BookMyBatisDAO dao = new BookMyBatisDAO();
        List<BookDTO> list = dao.bookList();

        // 특정 메모리에 꺼내온 DB 데이터 객체를 바인딩 하기(속성을 추가)
        req.setAttribute("list", list);     // "list"라는 이름에 실제 데이터가 위치한 번지가 저장이 된다.

        return "list";  // view의 논리적인 이름
    }
}
