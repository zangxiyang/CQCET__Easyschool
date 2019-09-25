package com.example.easyschool.service.impl;

import com.example.easyschool.model.Message;
import com.example.easyschool.model.User;
import com.example.easyschool.repository.MessageRepository;
import com.example.easyschool.service.MessageService;
import com.example.easyschool.utils.PredefineConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Message> findGetMsgByUser(User id, Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesByGetUserId(id,pageable);
    }

    @Override
    public Page<Message> findSendMsgByUser(User id, Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesBySendUserId(id,pageable);
    }

    @Override
    public Page<Message> findMsgBySys(User id,Pageable pageable) {
        return (Page<Message>) messageRepository.findMessagesByGetUserIdAndSysStatus(id,0,pageable);
    }

    @Override
    public Integer addMsgBySys(String content, User getUser) {
        Message message = new Message();
        message.setGetUserId(getUser)
                .setSysStatus(PredefineConstant.MESSAGE_SYSTEM.get())
                .setMsgContent(content);
        return addMsg(message);

    }

    @Override
    public Integer addMsgByUser(String content, User getUser, User sendUser) {
        Message message = new Message();
        message.setGetUserId(getUser)
                .setSendUserId(sendUser)
                .setSysStatus(PredefineConstant.MESSAGE_USER.get())
                .setMsgContent(content);
        return addMsg(message);
    }

    @Override
    public Integer delMsgByUser(Message msg) {
        try {
            messageRepository.delete(msg);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 添加信息
     * @param message 当前的message对象
     * @return 0添加失败,1成功
     */
    private Integer addMsg(Message message){
        try {
            messageRepository.save(message);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}
