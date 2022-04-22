package com.wyl.model;

/**
 * @ClassName Code
 * @Description TODO
 * @Author wyl
 * @Date 2022/2/25 17:05:13
 */
public enum Constant {
    SUCCESS_200("200","成功"),
    ERRORCODE_1("1","输入参数非法"),
    ERRORCODE_2("2","参数为空"),
    ERRORCODE_500("500","服务器出错");

    private String code;
    private String message;

    private Constant(String code, String message) {
        this.code=code;
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }
    public String getCode() {
        return this.code;
    }
}