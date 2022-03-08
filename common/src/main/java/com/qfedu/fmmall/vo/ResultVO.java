package com.qfedu.fmmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {

    //响应前端状态码
    private int code;
    //响应前端提示信息
    private String msg;
    //响应前端数据
    private String data;


}
