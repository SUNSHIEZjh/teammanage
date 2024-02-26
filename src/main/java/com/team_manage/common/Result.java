package com.team_manage.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一通用接口返回封装类
 *
 * @author XXX
 * @since 2023-11-09
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Result 统一返回类")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 后台是否处理成功（状态）
     */
    @ApiModelProperty(value = "后台返回状态")
    private boolean state;

    /**
     * 前后端约定的状态码（状态码）
     */
    @ApiModelProperty(value = "后台返回状态码")
    private int code;

    /**
     * 后台响应的信息（处理信息）
     */
    @ApiModelProperty(value = "后台返回处理信息")
    private String message;

    /**
     * 后台响应的数据（返回数据）
     */
    @ApiModelProperty(value = "后台响应的数据（返回数据）")
    private transient T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setState(true);
        result.setCode(Constant.SUCCESS_CODE);
        result.setMessage(Constant.SUCCESS);
        return result;
    }

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setState(true);
        result.setCode(Constant.SUCCESS_CODE);
        result.setMessage(Constant.SUCCESS);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(int code, String message) {
        Result<T> result = new Result<>();
        result.setState(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> success(int code, String message, T t) {
        Result<T> result = new Result<>();
        result.setState(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setState(false);
        result.setCode(Constant.FAIL_CODE);
        result.setMessage(Constant.FAIL);
        return result;
    }

    public static <T> Result<T> fail(T t) {
        Result<T> result = new Result<>();
        result.setState(false);
        result.setCode(Constant.FAIL_CODE);
        result.setMessage(Constant.FAIL);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> fail(int code, String message) {
        Result<T> result = new Result<>();
        result.setState(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> loginFail(int code, String message) {
        Result<T> result = new Result<>();
        result.setState(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fail(int code, String message, T t) {
        Result<T> result = new Result<>();
        result.setState(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(t);
        return result;
    }

}

