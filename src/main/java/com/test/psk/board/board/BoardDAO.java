package com.test.psk.board.board;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardDAO {

    List<BoardVO> selectList(ParamBoardVO param);
}
