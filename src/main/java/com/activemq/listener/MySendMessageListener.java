package com.activemq.listener;

import com.activemq.pojo.Mail;
import com.activemq.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-08 12:30
 * @Version: 1.0
 */
@Component("myListener")
public class MySendMessageListener implements MessageListener {
    @Autowired
    private MailService mailServiceImpl;

    /**
     * @description: 监听ActiveMQ消息队列
     * @param: message 消息对象
     * @Date: 2019-06-08 12:32
     * @return: void
     */
    @Override
    public void onMessage(Message message) {
        try {
            if(message instanceof ObjectMessage){
                ObjectMessage msg = (ObjectMessage) message;
                Object obj = msg.getObject();
                if(obj instanceof Mail){
                    mailServiceImpl.sendMessage(((Mail) obj));
                }
            }else{
                System.out.println(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
