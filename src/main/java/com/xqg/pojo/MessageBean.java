package com.xqg.pojo;
/**
 * @Author : YaweiZhang
 * @Description :
 * @Date : Created in 20:27 2018/3/28
 * @Modified by : YaweiZhang
 * @Param :
 */
public class MessageBean {
    public Integer code;
    public String message;

    public MessageBean() {

    }

    public MessageBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
