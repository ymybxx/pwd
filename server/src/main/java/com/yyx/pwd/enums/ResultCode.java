package com.yyx.pwd.enums;

public enum ResultCode {

    SUCCESS(0, "请求成功"),
    FAILURE(1,"请求失败"),
    PARAM_ERROR(400, "参数错误"),
    NO_HANDLER_FOUND(404, "url错误，请检查"),
    EXCEPTION(500, "服务内部出现异常"),
    INVAILDTOKEN(1000, "用户token认证失败，请重新登陆"),
    UPDATE_NONE(2000, "更新了0条记录"),
    RECORD_UNFIND(2001, "未查寻到相关记录"),
    LOCKED(2002, "有用户正在操作，请稍候再试");
    private int code;

    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}