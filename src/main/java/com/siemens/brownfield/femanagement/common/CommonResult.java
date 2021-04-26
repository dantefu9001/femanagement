package com.siemens.brownfield.femanagement.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code = HttpStatus.OK.value();
    private String message = HttpStatus.OK.getReasonPhrase();
    private T data;
}
