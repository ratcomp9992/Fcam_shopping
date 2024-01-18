package jdbc;

import com.example.entity.BookDAO;
import com.example.entity.BookDTO;

public class JDBC02 {
    public static void main(String[] args) {
        int num = 1;
        int price = 54000;
        int page = 390;

        BookDTO dto = new BookDTO();
        dto.setNum(num);
        dto.setPrice(price);
        dto.setPage(page);

        BookDAO dao = new BookDAO();
        int cnt = dao.bookUpdate(dto);
    }
}
