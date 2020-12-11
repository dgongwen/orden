package com.dgw.orden.Exception;
import com.dgw.orden.vo.StatusCode;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor 设定无参构造
 * RuntimeException 继承运行时异常
 */

@NoArgsConstructor
public class BaseException  extends RuntimeException{
    private int status;
    private String masses;

    //传入封装状态异常
    public  BaseException(StatusCode statusCode){
        this.status = statusCode.getStatus();
        this.masses = statusCode.getMsg();

    }

}
