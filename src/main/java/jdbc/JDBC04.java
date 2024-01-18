package jdbc;

import com.example.repository.BookDAO;
import com.example.entity.BookDTO;

import java.util.List;

public class JDBC04 {
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        List<BookDTO> list = dao.bookList();
    }
}
