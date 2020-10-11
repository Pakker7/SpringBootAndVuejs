package com.test.psk.demo.board;

import java.util.List;

public interface BoardService {

    List<BoardVO> selectList(ParamBoardVO param);
}
