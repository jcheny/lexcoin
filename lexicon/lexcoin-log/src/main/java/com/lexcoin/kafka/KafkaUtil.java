package com.lexcoin.kafka;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:chenyu
 * @Date: 2019/9/16 17:11
 */
public class KafkaUtil {

    /**
     * 封装kafka全局处理异常的消息对象
     * @param request
     * @param e
     * @return
     */
    public static String makeErrorLogToKafka(HttpServletRequest request, Exception e){
        e.printStackTrace();
        KafkaErrorLogVo kafkaErrorLogVo = new KafkaErrorLogVo();
        String mobile = (String) request.getAttribute("mobile");
        String message = e.getMessage();
        String servletPath = request.getServletPath();
        kafkaErrorLogVo.setAddress(servletPath);
        kafkaErrorLogVo.setMobile(mobile);
        kafkaErrorLogVo.setErrorMsg("error:" + message);
        //转化
        return JSON.toJSONString(kafkaErrorLogVo);
    }



}
