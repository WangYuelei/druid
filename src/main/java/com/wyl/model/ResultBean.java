package com.wyl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by wyl
 * Description : 消息返回通用Bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {

    //返回信息常量
    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAIL_MESSAGE = "fail";
    //返回状态码常量
    private static final String SUCCESS_CODE = "200";
    private static final String FAIL_CODE = "3";

    //状态码
    private String status;
    //返回信息
    private String message;

    private T body;

    /**
     * 默认成功响应
     *
     * @return
     */
    public static ResultBean ok() {
        return new ResultBean(SUCCESS_CODE, SUCCESS_MESSAGE,null);
    }
    /**
     * 默认成功响应
     *
     * @return
     */
    public static <T> ResultBean ok(T data) {
        return new ResultBean(SUCCESS_CODE, SUCCESS_MESSAGE,data);
    }
    /**
     * 自定义相应信息，成功响应
     *
     * @return
     */
    public static<T> ResultBean responseOk(String msg,T data) {
        return new ResultBean(SUCCESS_CODE, msg,null);
    }
    /**
     * 自定义状态吗和信息，成功响应
     *
     * @return
     */
    public  static<T> ResultBean responseOk(String code, String msg,T data) {
        return new ResultBean(code, msg,data);
    }
    /**
     * 默认失败相应
     *
     * @return
     */
    public static ResultBean fail() {
        return new ResultBean(FAIL_CODE, FAIL_MESSAGE,null);
    }

    /**
     * 自定义信息，失败响应
     *
     * @return
     */
    public static ResultBean responseFail(String msg) {
        return new ResultBean(FAIL_CODE, msg,null);
    }

    /**
     * 自定义状态码和信息，失败响应
     *
     * @return
     */
    public static ResultBean responseFail(String code, String msg) {
        return new ResultBean(code, msg,null);
    }
    public static ResultBean responseFail(Constant constant) {
        return new ResultBean(constant.getCode(), constant.getMessage(),null);
    }
    /**
     * 自定义状态码和信息响应
     * 推荐使用
     * @return
     */
    public  static<T> ResultBean getInstance(String code, String msg,T data) {
        return new ResultBean(code, msg,data);
    }
}