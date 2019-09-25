package com.example.easyschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * FileName: Reply
 * Author: 臧锡洋
 * Date: 2019-09-25-16:26
 * 描述: 回复表
 */

@Entity
@Table(name = "es_reply")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //主键
    @Column
    private Integer commentId; //评论id
    /**回复类型,可以针对回复进行回复,也可以针对评论进行回复,两个场景
     *1为回复评论,
     *2为回复回复;
     */
    @Column
    private Integer replyType;
    @Lob
    @Column(columnDefinition="TEXT")
    private String content; // 内容
    @OneToOne
    @JoinColumn(name = "from_uid")
    private User fromUid; //回复用户
    @OneToOne
    @JoinColumn(name = "to_uid")
    private User toUid; //目标用户


}
