package com.test.psk.demo.web;

import com.test.psk.demo.web.board.old.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬북기능테스트(){
        //given
        String name="name";
        int amount =1;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);
        //then

        System.out.println(dto.getAmount());
        System.out.println(dto.getName());
        assertThat(dto.getName().equals(name));

    }
}
