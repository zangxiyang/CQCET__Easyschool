package com.example.easyschool.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FileName: Resultlnfo
 * Author:   刘帅
 * Date:     2019-9-21 10:52
 */
public class Resultlnfo<T> {
    private Integer result;
    private String msg;
    private String data;
    private T rows;
    private int total;

    public Integer getResult() {
        if (result==null||"".equals(result))
            return 0;
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Result validata(String page,String size){
        Result result=new Result();
        Pattern pattern=Pattern.compile("^(0|[1-9][0-9]*)$");
        Matcher pageIsNum=pattern.matcher(page);
        Matcher sizeIsNum=pattern.matcher(size);
        if (!pageIsNum.matches()){
            result.setMsg("请求数据失败，传入page参数不对");
        }
        if (sizeIsNum.matches()){
            result.setMsg("请求数据失败，传入size参数不对");
        }
        return result;
    }
}
