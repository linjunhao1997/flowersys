package com.junhow.gp.exception;

/**
 * 系统异常(SystemException)
 * @author linjunhao
 * @date 2018/8/30 13:59
 */
public class SystemException extends RuntimeException {

    public SystemException(String msg){
        super(msg);
    }

    public SystemException() {
        super();
    }
}
