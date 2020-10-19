package com.test.psk.demo.web.board;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter //setter가 있는 이유 : Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔 기본생성자 + set메소드를 통해서만 값이 할당됨
@NoArgsConstructor
public class BoardRequestDto {

//    BoardVO 와 유사한 이 dto가 있는 이유?
//    Entity 클래스는 가장 Core한 클래스
//    수많은 서비스 클래스나 비지니스 로직들이 Entity 클래스를 기준으로 동작함
//    Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면 Request와 Response용 DTO는 View를 위한 클래스라 정말 자주 변경이 필요함
//    따라서 View Layer와 DB Layer를 철저하게 역할 분리를 하는게 좋음

    private String title;
    private String contents;
    private String writer;

    @Builder
    public BoardVO toEntity(){
        return BoardVO.builder()
                .title(title)
                .contents(contents)
                .writer(writer)
                .build();
    }
}
