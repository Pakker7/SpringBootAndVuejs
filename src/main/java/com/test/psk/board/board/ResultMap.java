package com.test.psk.board.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ResultMap {
    private Object result;

    public ResultMap(Object result) {
        this.result = result;
    }
}
