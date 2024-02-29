package com.cen.springbootdemo.service;

import com.cen.springbootdemo.service.bean.EmailDomain;

public class EmailServiceImpl implements EmailService{


    @Override
    public void sendMail(EmailDomain email) {

        //Mock call email-service using rest-template/eureka or use java-mail(SMTP)to send email to specified receiver

    }
}
