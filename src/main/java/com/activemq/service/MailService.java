package com.activemq.service;

import com.activemq.pojo.Mail;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-08 12:24
 * @Version: 1.0
 */
public interface MailService {
    public void sendMessage(Mail mail);
}
