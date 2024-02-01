package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMyBatisDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginController implements Controller  {   // JSON을 응답하는 Controller : RestController
    public String requestHandler (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 회원 인증처리

        // UserDTO 만들기
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDTO dto = new UserDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setUserid("관리자");

/*
        // DB 연동
       BookMyBatisDAO dao = new BookMyBatisDAO();
        UserDTO user = dao.userLogin(dto);
        if (user != null) {     // 회원 인증 성공
            HttpSession session = req.getSession();
            session.setAttribute("uservo", dto);
        }
        return "list";  // list.jsp (인증 여부 판단 로직)
*/

        if (username.equals("admin") && password.equals("admin")) {
            // 회원 인증 성공했다면? -> View(jsp)가 알아야 한다. : 객체 바인딩(HttpSession)
            // JSESSIONID : 32string으로 만들어진 고유한 값 (req에 포함되어있음)
            // 로그인에 성공했다는 사실을 session의 JSessionID를 통해 전달한다.
            HttpSession session = req.getSession();
            session.setAttribute("uservo", dto); // 세션을 만들고 객체를 바인딩
        }

        return "redirect:list.do";  // list.jsp (인증 여부 판단 로직)
    }
}
