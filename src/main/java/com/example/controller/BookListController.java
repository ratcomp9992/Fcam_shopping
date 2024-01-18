package com.example.controller;

import com.example.entity.BoardDTO;
import com.example.entity.BookDTO;
import com.example.repository.BookDAO;

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

@WebServlet("/list")
public class BookListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 요청을 받은 Controller가 어떻게 View로 이동을 시켜줄까?
        // Controller와 View를 연동해야한다. => 포워딩(forward), 요청 의뢰(RequestDispatcher)
        // Controller가 View로 데이터(Object + DTO, List<DTO> 등)을 보내야 한다. => 객체 바인딩(Object Binding)

        // 데이터 : 게시판 리스트 (BoardDTO) -> List<BoardDTO>

/*
        List<BoardDTO> list = new ArrayList<>();
        list.add(new BoardDTO(1, "게시판 연습1", "게시판 연습1", "관리자1", new Date(), 0));
        list.add(new BoardDTO(2, "게시판 연습2", "게시판 연습2", "관리자2", new Date(), 1));
        list.add(new BoardDTO(3, "게시판 연습3", "게시판 연습3", "관리자3", new Date(), 2));
*/
        // DB에서 데이터를 꺼내옴
        BookDAO dao = new BookDAO();
        List<BookDTO> list = dao.bookList();

        // 특정 메모리에 꺼내온 DB 데이터 객체를 바인딩 하기(속성을 추가)
        req.setAttribute("list", list);     // "list"라는 이름에 실제 데이터가 위치한 번지가 저장이 된다.

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        rd.forward(req, resp);
    }
}
