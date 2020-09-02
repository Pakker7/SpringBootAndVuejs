package com.test.psk.demo.board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardDAO {

    @Select("SELECT  NO, TITLE, CONTENTS, WRITER, DATE FROM BOARD ORDER BY DATE DESC")
    List<BoardVO> selectList(ParamBoardVO param);
}
