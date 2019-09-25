package com.example.easyschool.utils;

/**
 * @ author Seale
 * @ Description: 基础工具包 V1
 * @ QQ:1801157108
 * @ Date 2019/9/26 1:59
 */
public class BaseUtils {
    public static boolean isEmpty(String str){
        if (str.equals("")||str.equals(" ")||str.isEmpty()){
            return true;
        }else
            return false;
    }
}
