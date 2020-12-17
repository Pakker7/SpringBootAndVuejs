package com.test.psk.demo.web.board.old;

import com.test.psk.demo.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceOldImpl implements BoardServiceOld {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<Board> selectList(ParamBoardVO param) {
        return boardDAO.selectList();
    }

    @Override
    public Board get(ParamBoardVO param) {
        return boardDAO.get(param);
    }

    @Override
    public int create(ParamBoardVO param) {
        return boardDAO.create(param);
    }

    @Override
    public int update(ParamBoardVO param) {
        return boardDAO.update(param);
    }

    @Override
    public int delete(ParamBoardVO param) {
        return boardDAO.delete(param);
    }
}
