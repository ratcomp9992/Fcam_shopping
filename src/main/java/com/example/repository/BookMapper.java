package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    public List<BookDTO> bookList();
    public int bookInsert(BookDTO book);
    public int bookDelete(int num);
    public UserDTO userLogin(UserDTO dto);
}
