package com.example.easyschool.repository;

import com.example.easyschool.model.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * FileName: CommentsRepository
 * Author: 臧锡洋
 * Date: 2019-09-25-11:25
 */

public interface CommentsRepository extends JpaRepository<Comments,Integer>
        ,JpaSpecificationExecutor {

    Page<Comments> findByPostId(String id, Pageable pageable);
}
