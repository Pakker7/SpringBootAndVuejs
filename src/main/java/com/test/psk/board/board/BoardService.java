package com.test.psk.board.board;

import java.util.List;

public interface BoardService {

    List<BoardVO> selectList(ParamBoardVO param);
}
