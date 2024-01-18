package com.example.entity;

public class BookDTO {
    private int num;
    private String title;
    private int price;
    private String name;
    private int page;

    public BookDTO() {

    }

    public BookDTO(String title, int price, String name, int page) {
        this.title = title;
        this.price = price;
        this.name = name;
        this.page = page;
    }

    public BookDTO(int num, String title, int price, String name, int page) {
        this.num = num;
        this.title = title;
        this.price = price;
        this.name = name;
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
