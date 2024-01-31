package com.example.frontcontroller;

public class ViewResolver {
    public static String makeView(String view) {

        return "/WEB-INF/views/" + view + ".jsp";
    }
}
