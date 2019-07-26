package com.activemq.service.impl;

import com.activemq.pojo.Mail;
import com.activemq.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-08 12:25
 * @Version: 1.0
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SimpleMailMessage mailMessage;
    @Autowired
    private ThreadPoolTaskExecutor pool;

    /*
     * 使用JavamailAPI发送邮件信息
     */
    @Override
    public void sendMessage(final Mail mail) {
        this.pool.execute(new Runnable() {
            @Override
            public void run() {
                mailMessage.setTo(mail.getTo());
                mailMessage.setSubject(mail.getSuject());
                mailMessage.setText(mail.getContent());
                javaMailSender.send(mailMessage);
            }
        });
    }
}
