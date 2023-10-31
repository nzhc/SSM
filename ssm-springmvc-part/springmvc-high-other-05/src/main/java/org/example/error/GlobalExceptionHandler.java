package org.example.error;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice // 等于 @ResponseBody + @ControllerAdvice，其中advice表明是全局异常处理
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e){
        // 自定义处理异常即可
        return null;
    }

    @ExceptionHandler(Exception.class)
    public Object ExceptionHandler(Exception e){
        // 自定义处理异常即可
        return null;
    }
}
