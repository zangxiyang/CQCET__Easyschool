package com.example.easyschool.model;

/*
 * @author: 邓磊
 *
 * @detail: 发帖model
 * @date: 2019/9/20
 * */

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 *@Classname: Posting
 *@Description: TODO
 *@Date: 2019/9/23 11:40
 *@Created by: 邓磊
 */
@ToString
@Getter
@Setter
@Table(name = "es_posting")
@Entity
@GenericGenerator(name = "jpa-uuid",strategy = "uuid")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    //主键
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "post_id")
    private String postId;
    //用户id
    @Column(name = "user_id")
    private String userId;
    //标题
    @Column(name = "title")
    private String title;
    //帖子内容
    @Column(name = "content")
    private String content;
    //评论总数
    @Column(name = "comment_count")
    private Integer commentCount;
    //总数
    @Column(name = "likes_count")
    private Integer likesCount;
    //发帖时间
    @Column(name = "post_time")
    private String postTime;
    //帖子最后修改时间
    @Column(name = "update_time")
    private String updateTime;
    //帖子最后修改人外键
    @Column(name = "final_update_user")
    private String finalUpdateUser;

}