package com.example.easyschool.utils;

/**
 * FileName: PredefineConstant
 * Author: 臧锡洋
 * Date: 2019-09-25-17:28
 * 描述: 预定义常量池
 */
public enum  PredefineConstant {
    MESSAGE_SYSTEM(0),MESSAGE_USER(1);

    private final Integer i;

    PredefineConstant(Integer i) {
        this.i = i;
    }
    public Integer get(){
        return i;
    }
}
