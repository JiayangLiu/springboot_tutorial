package com.tutorial.springboot_tutorial.handler;

import com.tutorial.springboot_tutorial.domain.Result;
import com.tutorial.springboot_tutorial.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
@ControllerAdvice
public class ExcepHandler {

    // fetch exception
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        return ResultUtil.error(2, e.getMessage());
    }
}
