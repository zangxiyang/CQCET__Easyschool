package com.example.easyschool.controller;

import com.example.easyschool.model.Message;
import com.example.easyschool.model.User;
import com.example.easyschool.service.MessageService;
import com.example.easyschool.service.UserService;
import com.example.easyschool.utils.Resultlnfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: MessageController
 * Author: 臧锡洋
 * Date: 2019-09-23-16:16
 */
@RestController
@RequestMapping("/msg")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @ApiOperation(value = "消息通知",notes = "消息通知,可为系统对用户,可以是用户对用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size" , value = "可空,默认大小为15",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page" , value = "可空,默认为0,显示的页数",dataType = "int" ,paramType = "query")
    })
    @GetMapping("/findMsg")
    public Resultlnfo<Page> findMsg(@RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                     @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                     @PageableDefault(value = 0,size = 15)Pageable pageable){
        Resultlnfo<Page> resultlnfo=new Resultlnfo<>();
        try {
            Page<Message> Plist=messageService.findAllMsg(pageable);
            resultlnfo.setRows(Plist);
            resultlnfo.setTotal((int)Plist.getTotalElements());
            resultlnfo.setMsg("查询成功");
            resultlnfo.setResult(1);
        }catch (Exception e){
            resultlnfo.setMsg(e.toString());
            resultlnfo.setResult(-1);
        }
        return resultlnfo;
    }
}
