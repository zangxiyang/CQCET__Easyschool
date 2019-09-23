package com.example.easyschool.repository;

import com.example.easyschool.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * FileName: MessageRepository
 * Author: 臧锡洋
 * Date: 2019-09-23-14:56
 */
public interface MessageRepository extends
        JpaRepository<Message,Integer>,JpaSpecificationExecutor {

    List<Message> findMessagesByGetUserId(String id , Pageable pageable);

    List<Message> findMessagesBySendUserId(String id , Pageable pageable);

    List<Message> findMessagesByGetUserIdAndSysStatus(String id , Integer status, Pageable pageable);


}
