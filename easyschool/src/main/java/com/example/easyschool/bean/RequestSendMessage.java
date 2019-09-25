package com.example.easyschool.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ author Seale
 * @ Description: Post请求,发送消息通知 Body
 * @ QQ:1801157108
 * @ Date 2019/9/26 1:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class RequestSendMessage implements Serializable {
    private static final long serialVersionUID = 1487866748729632859L;
    //需要发送的内容
    private String content;
    //发送者
    private String sendUid;
    //接受者
    private String getUid;
}
