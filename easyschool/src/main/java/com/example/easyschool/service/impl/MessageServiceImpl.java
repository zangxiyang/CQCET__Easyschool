package com.example.easyschool.service.impl;

import com.example.easyschool.model.Message;
import com.example.easyschool.repository.MessageRepository;
import com.example.easyschool.repository.Userepository;
import com.example.easyschool.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * FileName: MessageServiceImpl
 * Author: 臧锡洋
 * Date: 2019-09-23-15:25
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Page<Message> findAllMsg(Pageable pageable) {
        return  messageRepository.findAll(pageable);
    }

    @Override
    public Message findMsgById(Integer id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public Page<Message> findGetMsgByUser(String id, Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesByGetUserId(id,pageable);
    }

    @Override
    public Page<Message> findSendMsgByUser(String id, Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesBySendUserId(id,pageable);
    }

    @Override
    public Page<Message> findMsgBySys(String id,Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesByGetUserIdAndSysStatus(id,0,pageable);
    }

}
