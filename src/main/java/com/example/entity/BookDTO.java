package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Lombok API
@AllArgsConstructor // 오버로딩된 생성자
@NoArgsConstructor  // 기본 생성자
public class BookDTO {
    private int num;
    private String title;
    private int price;
    private String name;
    private int page;
}
