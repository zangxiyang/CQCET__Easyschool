package com.example.easyschool.repository;

import com.example.easyschool.model.Message;
import com.example.easyschool.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * FileName: MessageRepository
 * Author: 臧锡洋
 * Date: 2019-09-23-14:56
 */
public interface MessageRepository extends
        JpaRepository<Message,Integer>,JpaSpecificationExecutor {

    Page<Message> findMessagesByGetUserId(User id , Pageable pageable);

    List<Message> findMessagesBySendUserId(User id , Pageable pageable);

    List<Message> findMessagesByGetUserIdAndSysStatus(User id , Integer status, Pageable pageable);

}
