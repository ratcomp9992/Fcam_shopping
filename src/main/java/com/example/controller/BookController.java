package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMapper;
import com.example.repository.BookMyBatisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller // Spring에서 POJO를 나타내기 위해 사용하는 어노테이션
public class BookController {
    // BookDelete, BookList, BookRegister, BookRegisterPost
    // 4개의 단위 업무를 혼자서 처리
    @Autowired
    private BookMapper mapper;
    @RequestMapping("/list")
    public String list(Model model) {
        List<BookDTO> list = mapper.bookList();

        model.addAttribute("list", list);
        return "list";      // /WEB-INF/views/list.jsp
    }
}
