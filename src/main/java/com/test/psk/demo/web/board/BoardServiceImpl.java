package com.test.psk.demo.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> selectList(ParamBoardVO param) {
        return boardDAO.selectList();
    }

    @Override
    public BoardVO get(ParamBoardVO param) {
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
