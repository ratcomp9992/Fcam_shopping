package com.example.controller;

import com.example.entity.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller  {   // JSON을 응답하는 Controller : RestController
    public String requestHandler (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그아웃 처리
        HttpSession session = req.getSession();
        session.invalidate();   // 세션 무효화

        return "redirect:list.do";  // list.jsp (인증 여부 판단 로직)
    }
}
