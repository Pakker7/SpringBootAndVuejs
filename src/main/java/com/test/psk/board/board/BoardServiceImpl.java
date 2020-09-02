package com.test.psk.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> selectList(ParamBoardVO param) {
        return boardDAO.selectList(param);
    }
}
