package com.suqc.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class DefaultQueueMessageListener implements MessageListener {
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Override
    public void onMessage(Message message) {
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println("defaultQueueMessageListener接收到:"+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
