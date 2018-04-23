package com.suqc.controller;

import com.sun.deploy.panel.JSmartTextArea;
import com.suqc.utils.JmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

@Controller
@RequestMapping("/activemq")
public class ActiveMQController {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    Destination defaultQueueDestination;
    @RequestMapping("/send")
    @ResponseBody
    public Object send() {
        for (int i = 0; i < 1000; i ++) {
            JmsUtil.sendMessage(jmsTemplate,defaultQueueDestination,"消息"+i);
        }
        return "success";
    }

}
