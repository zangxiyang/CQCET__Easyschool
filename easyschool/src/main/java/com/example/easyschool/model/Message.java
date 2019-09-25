package com.example.easyschool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
@EntityListeners(AuditingEntityListener.class)
public class Message implements Serializable {
    private static final long serialVersionUID = 6525870128995764506L;
    //消息通知的唯一标识
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id ;
    //消息内容
    @Lob
    @Column(nullable = false,columnDefinition="TEXT")
    private String msgContent;
    //消息内容的接受者
    @OneToOne
    @JoinColumn(nullable = false)
    private User getUserId;
    //消息内容的发送者,这个字段可为空
    @OneToOne
    @JoinColumn(nullable = true)
    private User sendUserId;
    //是否为系统通知的表示,0为系统通知,1为用户消息,这个字段不可为空
    @Column(nullable = false)
    private Integer sysStatus;
    //消息的创建时间
    @CreatedDate
    @Column
    private Date CreateTime;

}
