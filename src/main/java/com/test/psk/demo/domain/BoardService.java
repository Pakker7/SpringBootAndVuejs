package com.test.psk.demo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되 조회 기능만 남겨두어 조회 속도가 개선되게끔 함
    public List<BoardListResponseDto> findAllDesc(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new) //TODO 여기가 안되서 해결해야함
                .collect(Collectors.toList());
    }

    public BoardResponseDto findById(Long no){
        Board entity = boardRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. no="+ no));
        return new BoardResponseDto(entity);
    }
}
