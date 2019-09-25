package com.example.easyschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;


/**
 * FileName: Comments
 * Author: 臧锡洋
 * Date: 2019-09-25-10:31
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "es_comments")
@EntityListeners(AuditingEntityListener.class)
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;
    @Column
    private String agent;
    @Column
    private Integer star;
    @Column
    private String postId;
    @CreatedDate
    @Column
    private Date date;
}
