package com.example.easyschool.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * FileName: Message
 * Author:   臧锡洋
 * Date:     2019年9月23日13:36:35
 */
@Getter
@Setter
@Accessors(chain = true) //链式调用
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "es_message")
public class Message {
    //消息通知的唯一标识
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id ;
    //消息内容
    @Column(nullable = false)
    private String msgContent;
    //消息内容的接受者
    @Column(nullable = false)
    private String getUserId;
    //消息内容的发送者,这个字段可为空
    @Column(nullable = true)
    private String sendUserId;
    //是否为系统通知的表示,0为系统通知,1为用户消息,这个字段不可为空
    @Column(nullable = false)
    private Integer sysStatus;
    //消息的创建时间
    @Column
    private String CreateTime;

}
