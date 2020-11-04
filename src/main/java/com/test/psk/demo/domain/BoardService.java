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
    public Long update(Long no, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+ no));
        board.update(requestDto.getTitle(), requestDto.getContents());

        return no;
    }

    public BoardResponseDto findById(Long no){
        Board entity = boardRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. no="+ no));
        return new BoardResponseDto(entity);
    }
}
