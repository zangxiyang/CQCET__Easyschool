package com.example.easyschool.service;


import com.example.easyschool.model.Message;
import com.example.easyschool.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * FileName: MessageService
 * Author: 臧锡洋
 * Date: 2019-09-23-14:54
 */
public interface MessageService {
    //查询所有的Message信息
    Page<Message> findAllMsg(Pageable pageable);
    //根据Message信息ID查询
    Message findMsgById(Integer id);
    //查询指定用户接受的Message信息
    Page<Message> findGetMsgByUser(String id, Pageable pageable);
    //查询指定用户发送的Message信息
    Page<Message> findSendMsgByUser(String id, Pageable pageable);
    //查询指定用户的系统通知
    Page<Message> findMsgBySys(String id,Pageable pageable);

}
