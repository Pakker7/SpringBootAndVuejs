package com.test.psk.demo.board;

import java.util.List;

public interface BoardService {

    List<BoardVO> selectList(ParamBoardVO param);

    BoardVO get(ParamBoardVO param);

    int create(ParamBoardVO param);

    int update(ParamBoardVO param);

    int delete(ParamBoardVO param);
}
