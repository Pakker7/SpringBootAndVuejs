package com.test.psk.demo.web.board.old;

import com.test.psk.demo.domain.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private SqlSession sqlSession;

    private final String NAMESPACE = "com.test.psk.demo.web.board.";

    public List<Board> selectList(){
        return sqlSession.selectList(NAMESPACE + "selectList");
    }

    public Board get(ParamBoardVO param){
        return sqlSession.selectOne(NAMESPACE + "get", param);
    }

    int create(ParamBoardVO param){
        return sqlSession.insert(NAMESPACE + "create", param);
    }

    int update(ParamBoardVO param){
        return sqlSession.update(NAMESPACE + "update", param);
    }

    int delete(ParamBoardVO param){
        return sqlSession.delete(NAMESPACE + "delete", param);
    }
}
