package com.heim.underrose.controller;

import com.heim.underrose.bean.req.DestoryReq;
import com.heim.underrose.bean.req.MassReq;
import com.heim.underrose.bean.vo.MassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@RestController
public class ReceiveController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/mass/{address}")
    @SendTo("/topic/{address}")
    public MassVO mass(MassReq massReq, @DestinationVariable String address){
        MassVO massVO = new MassVO();
        massVO.setMsg(massReq.getMsg());
        massVO.setName(massReq.getName());
        massVO.setTime(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        massVO.setUuid(UUID.randomUUID().toString());
        return massVO;
    }

    @MessageMapping("/mass/destory")
    public void destory(@RequestBody DestoryReq destoryReq){
        System.out.println(destoryReq.getAddress());
        System.out.println("success");
    }
}
