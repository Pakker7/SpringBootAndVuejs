package com.test.psk.demo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardRequestDto requestDto){
        return boardRepository.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        board.update(requestDto.getTitle(), requestDto.getContents());

        return id;
    }

    public BoardResponseDto findById(Long id){
        Board entity = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        return new BoardResponseDto(entity);
    }
}
