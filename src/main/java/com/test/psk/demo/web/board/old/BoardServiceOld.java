package com.test.psk.demo.web.board.old;

import com.test.psk.demo.domain.Board;

import java.util.List;

public interface BoardServiceOld {

    List<Board> selectList(ParamBoardVO param);

    Board get(ParamBoardVO param);

    int create(ParamBoardVO param);

    int update(ParamBoardVO param);

    int delete(ParamBoardVO param);
}
