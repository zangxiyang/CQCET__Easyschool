package com.example.easyschool.controller;

import com.example.easyschool.bean.RequestSendMessage;
import com.example.easyschool.model.Message;
import com.example.easyschool.model.User;
import com.example.easyschool.service.MessageService;
import com.example.easyschool.utils.BaseUtils;
import com.example.easyschool.utils.PredefineConstant;
import com.example.easyschool.utils.ResultInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

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
    @ApiOperation(value = "消息通知",notes = "消息通知,查找所有通知信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "size" , value = "可空,默认大小为15",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page" , value = "可空,默认为0,显示的页数",dataType = "int" ,paramType = "query")
    })
    @GetMapping("/findAllMsg")
    public ResultInfo<Page> findMsg(@RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                    @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                    @PageableDefault(value = 0,size = 15)Pageable pageable){
        ResultInfo<Page> resultlnfo=new ResultInfo<>();
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
    @ApiOperation(value = "消息通知",notes = "消息通知,获得指定用户收到的消息通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "不可空,用户的唯一标识ID",dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "size" , value = "可空,默认大小为15",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page" , value = "可空,默认为0,显示的页数",dataType = "int" ,paramType = "query")
    })
    @GetMapping("/getMsgForUser/{id}")
    public ResultInfo<Page> getMsgForUser(@PathVariable String id,
                                          @RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                          @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                          @PageableDefault(value = 0,size = 15)Pageable pageable){
        ResultInfo<Page> resultInfo = new ResultInfo<>();
        String msg = "";
        Integer code = PredefineConstant.RESULT_ERRO.get();
        if (BaseUtils.isEmpty(id)){
            msg = "必要参数不能为空,请检查你的请求!";
            code = PredefineConstant.RESULT_ERRO.get();
            resultInfo.setTotal(0);
            resultInfo.setRows(null);
            resultInfo.setMsg(msg);
            resultInfo.setResult(code);
            return resultInfo;
        }
        User user = new User();
        user.setId(id);
        try {
            Page<Message> Plist=messageService.findGetMsgByUser(user,pageable);
            resultInfo.setRows(Plist);
            resultInfo.setTotal((int)Plist.getTotalElements());
            resultInfo.setMsg("查询成功");
            resultInfo.setResult(PredefineConstant.RESULT_SUCCESS.get());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setMsg(e.toString());
            resultInfo.setResult(PredefineConstant.RESULT_ERRO.get());
        }
        return resultInfo;
    }
    @ApiOperation(value = "消息通知",notes = "消息通知,获得指定用户发送的消息通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "不可空,用户的唯一标识ID",dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "size" , value = "可空,默认大小为15",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page" , value = "可空,默认为0,显示的页数",dataType = "int" ,paramType = "query")
    })
    @GetMapping("/sendMsgForUser/{id}")
    public ResultInfo<Page> sendMsgForUser(@PathVariable String id,
                                           @RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                           @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                           @PageableDefault(value = 0,size = 15)Pageable pageable){
        ResultInfo<Page> resultInfo = new ResultInfo<>();
        String msg = "";
        Integer code = PredefineConstant.RESULT_ERRO.get();
        if (BaseUtils.isEmpty(id)){
            msg = "必要参数不能为空,请检查你的请求!";
            code = PredefineConstant.RESULT_ERRO.get();
            resultInfo.setTotal(0);
            resultInfo.setRows(null);
            resultInfo.setMsg(msg);
            resultInfo.setResult(code);
            return resultInfo;
        }
        User user = new User();
        user.setId(id);
        try {
            Page<Message> Plist=messageService.findSendMsgByUser(user,pageable);
            resultInfo.setRows(Plist);
            resultInfo.setTotal((int)Plist.getTotalElements());
            resultInfo.setMsg("查询成功");
            resultInfo.setResult(PredefineConstant.RESULT_SUCCESS.get());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setMsg(e.toString());
            resultInfo.setResult(PredefineConstant.RESULT_ERRO.get());
        }
        return resultInfo;

    }
    @ApiOperation(value = "消息通知",notes = "消息通知,获得指定用户收到的系统消息通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "不可空,用户的唯一标识ID",dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "size" , value = "可空,默认大小为15",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "page" , value = "可空,默认为0,显示的页数",dataType = "int" ,paramType = "query")
    })
    @GetMapping("/sysMsgForUser/{id}")
    public ResultInfo<Page> sysMsgForUser(@PathVariable String id,
                                           @RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                           @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                           @PageableDefault(value = 0,size = 15)Pageable pageable){
        ResultInfo<Page> resultInfo = new ResultInfo<>();

        User user = new User();
        user.setId(id);
        try {
            Page<Message> Plist=messageService.findMsgBySys(user,pageable);
            resultInfo.setRows(Plist);
            resultInfo.setTotal((int)Plist.getTotalElements());
            resultInfo.setMsg("查询成功");
            resultInfo.setResult(PredefineConstant.RESULT_SUCCESS.get());
        }catch (Exception e){
            e.printStackTrace();
            resultInfo.setMsg(e.toString());
            resultInfo.setResult(PredefineConstant.RESULT_ERRO.get());
        }
        return resultInfo;

    }
    @ApiOperation(value = "消息通知",notes = "消息通知,删除一条消息通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "不可空,需要删除消息通知的ID",dataType = "String",paramType = "path")
    })
    @PostMapping("/delMsg/{id}")
    public ResultInfo<Integer> delMsg(@PathVariable("id") Integer id){
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        String msg = "";
        Integer resultCode = PredefineConstant.RESULT_ERRO.get();
        if (id==null){
            return checkParamEmpty(msg,resultCode,resultInfo);
        }
        Message message = new Message();
        message.setId(id);
        try {
            Integer result = messageService.delMsgByUser(message);
            msg = "成功一条删除消息通知";
            resultCode = PredefineConstant.RESULT_SUCCESS.get();
            resultInfo.setRows(result);
            resultInfo.setTotal(0);
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
        }catch (Exception e){
            e.printStackTrace();
            msg = "发生未知错误,请联系管理员";
            resultCode = PredefineConstant.RESULT_ERRO.get();
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
            e.printStackTrace();
        }
        return resultInfo;
    }

    @ApiOperation(value = "消息通知",notes = "消息通知,添加一条系统通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "不可空,内容体,其中getUid<接受者的id>/content<内容>",dataType = "String",paramType = "body")
    })
    @PostMapping("/sendSysMsg")
    public ResultInfo<Integer> sendSysMsg(@RequestBody RequestSendMessage message){
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        //拆分信息

        String getUid = message.getGetUid();
        String content = message.getContent();
        String msg = "";
        Integer resultCode = PredefineConstant.RESULT_ERRO.get();
        if (BaseUtils.isEmpty(getUid)||BaseUtils.isEmpty(content)){
            return checkParamEmpty(msg,resultCode,resultInfo);
        }
        User getUser = new User();
        getUser.setId(getUid);
        try {
            Integer result = messageService.addMsgBySys(content,getUser);
            msg = "已经成功发送一条系统消息给指定用户";
            resultCode = PredefineConstant.RESULT_SUCCESS.get();
            resultInfo.setRows(result);
            resultInfo.setTotal(0);
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
        }catch (Exception e){
            e.printStackTrace();
            msg = "发生未知错误,请联系管理员";
            resultCode = PredefineConstant.RESULT_ERRO.get();
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
            e.printStackTrace();
        }
        return resultInfo;
    }
    @ApiOperation(value = "消息通知",notes = "消息通知,添加一条用户对用户的消息通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "不可空,内容体,其中getUid<接受者的id>/sendUid<发送者的Id>/content<内容>",dataType = "String",paramType = "body")
    })
    @PostMapping("/sendMsgToUser")
    public ResultInfo<Integer> sendMsgToUser(@RequestBody RequestSendMessage message){
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        //拆分信息
        String getUid = message.getGetUid();
        String content = message.getContent();
        String sendUid = message.getSendUid();
        String msg = "";
        Integer resultCode = PredefineConstant.RESULT_ERRO.get();
        if (BaseUtils.isEmpty(getUid)||BaseUtils.isEmpty(content)||BaseUtils.isEmpty(sendUid)){
            return checkParamEmpty(msg,resultCode,resultInfo);
        }
        User getUser = new User();
        getUser.setId(getUid);
        User sendUser = new User();
        sendUser.setId(sendUid);
        try {
            Integer result = messageService.addMsgByUser(content,getUser,sendUser);
            msg = "已经成功发送一条系统消息给指定用户";
            resultCode = PredefineConstant.RESULT_SUCCESS.get();
            resultInfo.setRows(result);
            resultInfo.setTotal(0);
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
        }catch (Exception e){
            e.printStackTrace();
            msg = "发生未知错误,请联系管理员";
            resultCode = PredefineConstant.RESULT_ERRO.get();
            resultInfo.setMsg(msg);
            resultInfo.setResult(resultCode);
            e.printStackTrace();
        }
        return resultInfo;
    }

    private ResultInfo<Integer> checkParamEmpty(String msg,Integer code , ResultInfo<Integer> resultInfo){
        msg = "必要参数不能为空,请检查你的请求!";
        code = PredefineConstant.RESULT_ERRO.get();
        resultInfo.setTotal(0);
        resultInfo.setRows(0);
        resultInfo.setMsg(msg);
        resultInfo.setResult(code);
        return resultInfo;
    }



}
