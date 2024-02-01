package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookMyBatisDAO {
    // MyBatis : SQL Mapping Framework

    // DB 연결 -> config.xml(환경설정파일) 필요 -> API가 읽어서 연결작업을 대신 해주면 된다.
    private static SqlSessionFactory sqlSessionFactory;     // ConnectionPool 생성
    static {    // 초기화 블럭
        try {
            String resource = "mybatis-config/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    // SELECT
    public List<BookDTO> bookList() {
        SqlSession session = sqlSessionFactory.openSession();

        // Mapper.xml에서 id와 resultType을 확인하고 SQL 쿼리문을 날려준다.
        List<BookDTO> list = session.selectList("bookList");

        session.close();    // Connection Pool에 반납
        return list;
    }

    // INSERT
    public int bookInsert(BookDTO book) {
        SqlSession session = sqlSessionFactory.openSession();

        int cnt = session.insert("bookInsert", book);

        session.commit();
        session.close();
        return cnt;
    }

    // DELETE
    public int bookDelete(int num) {
        SqlSession session = sqlSessionFactory.openSession();

        int cnt = session.delete("bookDelete", num);

        session.commit();
        session.close();
        return cnt;
    }

    public UserDTO userLogin(UserDTO dto) {
        SqlSession session = sqlSessionFactory.openSession();

        // Mapper.xml에서 id와 resultType을 확인하고 SQL 쿼리문을 날려준다.
        UserDTO user = session.selectOne("userLogin", dto);

        session.close();
        return user;
    }


}
