package com.zeroscc.ruralcredit.core.api;




import com.zeroscc.ruralcredit.core.exception.ServiceException;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class ApiRest<T>{

    /**
     * 响应消息
     */

    private String msg;
    /**
     * 响应代码,0为成功,1为失败
     */
    private Integer code;

    /**
     * 请求或响应body
     */
    protected T data;


    /**
     * 是否成功
     * @return
     */
    public boolean isSuccess(){
        return code.equals(0);
    }

    /**
     * 构造函数
     * @param error
     */
    public ApiRest(ServiceException error){
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

    /**
     * 构造函数
     * @param error
     */
    public ApiRest(ApiError error){
        this.code = error.getCode();
        this.msg = error.msg;
    }
}
