package com.example.controller;

import com.example.entity.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController     //JSON응답 -> RESTful Service(GET, POST, PUT, DELETE)
public class SpringRestController {
    @RequestMapping("/rest1")
    public @ResponseBody List<UserDTO> rest(){
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO(1, "CUST01", "CUST01", "관리자"));
        list.add(new UserDTO(2, "CUST02", "CUST02", "나도윤"));
        return list;    // List<UserDTO> ------- jackson-databind ------> JSON
    }
}
