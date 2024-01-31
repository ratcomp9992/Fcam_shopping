package com.example.frontcontroller;

import com.example.controller.BookListController;
import com.example.controller.BookRegisterController;
import com.example.controller.BookRegisterPostController;
import com.example.controller.Controller;
import com.example.entity.BookDTO;
import com.example.repository.BookMyBatisDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.do")
public class BookController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // FrontController

        // 1. 클라이언트의 요청을 분석하는 작업. -> /list, /delete, /update, ..?
        String reqPath = req.getRequestURI();   // /shopping/list

        String cPath = req.getContextPath();    // /shopping

        String command = reqPath.substring(cPath.length()); // /list

        // 2. 요청에 따른 분기 작업  -> HandlerMapping
        String nextView = null;
        Controller controller = null;
        HandlerMapping mapping = new HandlerMapping();
        controller = mapping.getController(command);
        nextView = controller.requestHandler(req, resp);

        // 3. View의 경로를 forward or redirect 결정
        if (controller != null) {
            if (nextView != null) {
                if (nextView.indexOf(":") == -1) {  // ":"이 없으면
                    RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextView));
                    rd.forward(req, resp);
                } else {
                    resp.sendRedirect(nextView.split(":")[1]);    // redirect:list.do    -> /shopping/list
                }
            }
        }
    }
}
