package com.example.easyschool.controller;

import com.example.easyschool.model.Comments;
import com.example.easyschool.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: CommentsController
 * Author: 臧锡洋
 * Date: 2019-09-25-11:30
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;



    @GetMapping("/test")
    Page<Comments> getPostComments(@PageableDefault(value = 0,size = 15)Pageable pageable){
        return null;
    }

}
