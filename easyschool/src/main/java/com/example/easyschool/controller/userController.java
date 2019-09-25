package com.example.easyschool.controller;

import com.example.easyschool.utils.ResultInfo;
import com.example.easyschool.model.User;
import com.example.easyschool.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * FileName: userController
 * Author:   刘帅
 * Date:     2019-9-21 9:44
 */
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @ApiOperation(value =  "分页查询",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "")
    })
    @GetMapping("/findAlluser")
    public ResultInfo<Page> finduser(@RequestParam(name = "size",defaultValue = "15",required = false)String size,
                                     @RequestParam(name = "page",defaultValue = "0",required = false)int page,
                                     @PageableDefault(value = 0,size = 15)Pageable pageable
                         ){
        User user=new User();
        ResultInfo<Page> resultlnfo=new ResultInfo<>();
        try {
            Page<User> Plist=userService.findPage(user,pageable);
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
