package com.yyx.pwd.entity;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yyx.pwd.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultModel<T> {

    /**
     * 返回错误码
     */
    private int code;

    /**
     * 返回错误信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 是否有下一页
     */
    private int hasMore;

    public ResultModel(int code, T data, String message,int hasMore) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.hasMore = hasMore;
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode) {
        return valueOf(resultCode, null, null,0);
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode, String message) {
        return valueOf(resultCode, null, message,0);
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode, T data) {
        return valueOf(resultCode, data, null,0);
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode, T data, String message,int hasMore) {
        if (StringUtils.isEmpty(message)) {
            message = resultCode.getMessage();
        }
        return new ResultModel<T>(resultCode.getCode(), data, message,hasMore);
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode, T data, String message) {
        if (StringUtils.isEmpty(message)) {
            message = resultCode.getMessage();
        }
        return new ResultModel<T>(resultCode.getCode(), data, message,0);
    }

    public static <T> ResultModel<T> valueOf(ResultCode resultCode, T data,int count, int size) {
        int hasMore =  setHasMore(count,size);
        return valueOf(resultCode, data, null,hasMore);
    }

    private static int setHasMore(int count, int size) {
        return count >= size ? 1 : 0;
    }

    public boolean success() {
        return this.code == ResultCode.SUCCESS.getCode();
    }
}

