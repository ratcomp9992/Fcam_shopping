package com.example.controller;

import com.example.action.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookRegisterController implements Controller {
    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "register";
    }
}
