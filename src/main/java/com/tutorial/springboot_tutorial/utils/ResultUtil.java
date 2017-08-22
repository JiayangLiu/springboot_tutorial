package com.tutorial.springboot_tutorial.utils;

import com.tutorial.springboot_tutorial.domain.Result;

/**
 * Created by JeremyLiu on 21/08/2017.
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    // for those whose success response is empty
    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
