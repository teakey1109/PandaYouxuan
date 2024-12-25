package org.example.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.vo.common.ResultCodeEnum;

@EqualsAndHashCode(callSuper = true)
@Data
public class PandaException extends RuntimeException {

    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public PandaException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

}
