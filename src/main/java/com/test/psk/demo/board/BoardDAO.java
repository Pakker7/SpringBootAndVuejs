package com.test.psk.demo.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private SqlSession sqlSession;

    private final String NAMESPACE = "com.test.psk.demo.board.";

    public List<BoardVO> selectList(){
        return sqlSession.selectList(NAMESPACE + "selectList");
    }
}
