package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // Spring에서 POJO를 나타내기 위해 사용하는 어노테이션
public class BookController {
    // BookDelete, BookList, BookRegister, BookRegisterPost
    // 4개의 단위 업무를 혼자서 처리
    @Autowired
    private BookMapper mapper;
    @GetMapping("/list")
    public String list(Model model) {
        List<BookDTO> list = mapper.bookList();

        model.addAttribute("list", list);
        return "list";      // /WEB-INF/views/list.jsp
    }

    @GetMapping("/delete/{num}")    // DELETE
    public String delete(@PathVariable int num) {
        int cnt = mapper.bookDelete(num);

        return "redirect:/list";
    }


    @GetMapping("/register")    // GET
    public String registerGet() {
        return "register";
    }

    @PostMapping("/registerPost")   // POST
    public String registerPost(BookDTO dto) {  // JSON으로 전달오면 @RequestBody
        int cnt = mapper.bookInsert(dto);
        return "redirect:/list";
    }
/*
    @GetMapping("/ajaxList")
    public @ResponseBody List<BookDTO> ajaxList() {
        List<BookDTO> list = mapper.bookList();
        return list;
    }

 */
}
