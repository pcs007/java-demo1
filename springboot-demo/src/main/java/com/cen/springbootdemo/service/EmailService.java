package com.cen.springbootdemo.service;

import com.cen.springbootdemo.service.bean.EmailDomain;

public interface EmailService {

    void sendMail(EmailDomain email);
}
