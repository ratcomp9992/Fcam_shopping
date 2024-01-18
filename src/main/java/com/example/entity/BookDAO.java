package com.example.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;   // SQL실행 결과(select)를 담는 객체

    public Connection getConnect() {
        String url = "jdbc:mysql://localhost:3306/books";    // ip, port, DB이름
        String username = "root";
        String password = "12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void dbClose() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // CRUD Method
    // Update
    public int bookUpdate(BookDTO book) {
        String SQL = "update booktbl set price=?, page=? where num=?";

        conn = getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, book.getPrice());
            ps.setInt(2, book.getPage());
            ps.setInt(3, book.getNum());

            cnt = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 예외 상관없이 무조건 처리되는 블럭
            dbClose();
        }

        return cnt;
    }

    public int bookDelete(BookDTO book) {
        String SQL = "delete from booktbl where num=?";

        conn = getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, book.getNum());

            cnt = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 예외 상관없이 무조건 처리되는 블럭
            dbClose();
        }

        return cnt;
    }

    public int bookInsert(BookDTO book) {
        String SQL = "insert into booktbl(title, price, name, page) " +
                "values ('?', '?', '?', '?')";

        conn = getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getPrice());
            ps.setString(3, book.getName());
            ps.setInt(4, book.getPage());

            cnt = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 예외 상관없이 무조건 처리되는 블럭
            dbClose();
        }

        return cnt;
    }

    // Select
    public List<BookDTO> bookList() {
        String SQL = "select * from booktbl";
        List<BookDTO> list = new ArrayList<>();

        conn = getConnect();    // Connection을 좀 여러 개 만들어서 재활용하는 기법을 써야한다. (ConnectionPool)
        try {
            ps = conn.prepareStatement(SQL);

            rs = ps.executeQuery();     // rs는 table의 제목컬럼의 주소를 가리킨다. 데이터의 유무를 판별하기 위해서는 커서를 다음줄로 내려야한다.
            while (rs.next()) {
                int num = rs.getInt("num");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String name = rs.getString("name");
                int page = rs.getInt("page");

                // 뽑은 데이터를 묶어서 담기
                BookDTO dto = new BookDTO(num, title, price, name, page);
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 예외 상관없이 무조건 처리되는 블럭
            dbClose();
        }

        return list;
    }



}
