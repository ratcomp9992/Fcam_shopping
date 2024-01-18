package jdbc;
// JDBC Programming
import java.sql.*;

public class JDBC01 {
    public static void main(String[] args) {
        // 1. Driver Class 다운로드
        // 2. Driver 설치 (연결) File -> Project Structure -> jar파일
        // 3. 접속 정보 확인
        String url = "jdbc:mysql://localhost:3306/books";    // ip, port, DB이름
        String username = "root";
        String password = "12345";

        // 4. 객체 생성
       // DriverManager dm = new com.mysql.cj.jdbc.Driver();  // 정적 로딩 방법 : 컴파일 시점에 Driver() 클래스가 반드시 존재해야 함

                                                              // DB가 변경이 된다면 코드를 직접 고쳐야 하기 때문에 유지보수가 어렵게 됨
        try {
            // 4. 객체 생성
            Class.forName("com.mysql.cj.jdbc.Driver");  // 동적 로딩 방법 : 보통 외부에서 받아온 클래스 명을 변수 안에 넣는다
            Connection conn = DriverManager.getConnection(url, username, password);

            // 5. SQL 문장 작성
            String title = "자바 스크립트";
            int price = 26000;
            String name = "김길동";
            int page = 500;

            String SQL = "insert into booktbl(title, price, name, page) values(?,?,?,?)";   // ? : 파라미터 1,2,3,4

            // 6. SQL 전송 객체(Statement, PreparedStatement : 미완성 SQL(파라미터가 있는 거)
            // prepareStatement(SQL)은 DB로 미완성된 SQL을 미리 전송해서 컴파일을 시켜본다. (물음표 빼고 오류 있는지 체크)
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, title);
            ps.setInt(2, price);
            ps.setString(3, name);
            ps.setInt(4, page);

            // 7. 실행 (다시 컴파일하지 않고 바로 실행됨 -> 매번 컴파일 하지 않아도 되기에 빠르다)
            int cnt = ps.executeUpdate();   // 실패하면 0, 성공하면 성공한 row의 갯수를 리턴

        } catch (Exception e) {     // 예외 다형성
            e.printStackTrace();
        }
    }
}
