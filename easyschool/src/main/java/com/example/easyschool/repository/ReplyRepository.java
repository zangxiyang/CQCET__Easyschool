package com.example.easyschool.repository;

import com.example.easyschool.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * FileName: ReplyRepository
 * Author: 臧锡洋
 * Date: 2019-09-25-16:57
 * 描述:
 */
public interface ReplyRepository
extends JpaRepository<Reply,Integer>,JpaSpecificationExecutor {


}
