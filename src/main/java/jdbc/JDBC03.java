package jdbc;

import com.example.entity.BookDAO;
import com.example.entity.BookDTO;

public class JDBC03 {
    public static void main(String[] args) {
        int num = 1;
        BookDTO dto = new BookDTO(num, title, price, name, page);
        dto.setNum(num);
        BookDAO dao = new BookDAO();
        dao.bookDelete(dto);
    }
}
