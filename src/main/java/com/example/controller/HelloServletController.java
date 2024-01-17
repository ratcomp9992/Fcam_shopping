package com.example.controller;

import com.example.service.MyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 웹에서 실행 가능한 클래스로 만들어야 한다. (WAS) -> Servlet
// main 메서드를 가지고 있으면 JavaSE가 되어버린다.
// Servlet의 기본 메서드 : doPost(), doGet(), service()

@WebServlet("/hello")   // Servlet Mapping
public class HelloServletController extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        MIME Type (서버가 클라이언트에게 응답하는 데이터의 종류. 미리 알려줘야 함)
         1. html
         2. json(REST API)
         3. image
         4. excel, pdf ..
         5. file
         6. mp3, mp4
        */
        response.setContentType("text/html;charset=UTF-8");
        // 응답 스트림(빨대)을 만드는 과정
        PrintWriter out = response.getWriter();

        int hap = MyUtil.hap();
        out.println("<html>");
        out.println("<body>");
        out.println("총합: " + hap);
        out.println("</body>");
        out.println("</html>");
    }
}
