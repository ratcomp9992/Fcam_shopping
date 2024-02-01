package com.example.controller;

import com.example.action.Controller;
import com.example.entity.BookDTO;
import com.example.repository.BookMyBatisDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookAjaxListController  implements Controller {   // JSON을 응답하는 Controller : RestController
    public String requestHandler (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB에서 데이터를 꺼내옴
        BookMyBatisDAO dao = new BookMyBatisDAO();
        List<BookDTO> list = dao.bookList();

        // 특정 메모리에 꺼내온 DB 데이터 객체를 바인딩 하기(속성을 추가)
        req.setAttribute("list", list);     // "list"라는 이름에 실제 데이터가 위치한 번지가 저장이 된다.

        // View가 없어서 jsp파일의 경로 대신 Json 데이터를 전달하고자 한다.

        Gson gson = new Gson();
        String json = gson.toJson(list);
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println(json);

        return null;
    }
}
