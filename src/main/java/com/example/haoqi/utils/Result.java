package com.example.haoqi.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Object data;
    private boolean success;
    private String message;
    private Integer code;

    // 把构造方法私有
    private Result(){}

    // 成功静态方法
    public static Result ok(){
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    // 失败静态方法
    public static Result error(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public static Result tokenError(){
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(ResultCode.TOKENFALSE);
        r.setMessage("失败");
        return r;
    }
    // 设置数据
    public Result data(Object object){
        this.setData(object);
        return this;
    }
    public void setData(Object data){ this.data = data; }
    public Object getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
