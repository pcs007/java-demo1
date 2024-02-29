package com.cen.springbootdemo.service;

import com.cen.springbootdemo.constants.BasicConstants;
import com.cen.springbootdemo.dao.BasicDao;
import com.cen.springbootdemo.service.bean.EmailDomain;
import com.cen.springbootdemo.web.domain.UserContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService{

    @Autowired
    private BasicDao basicDao;

    @Autowired
    private EmailService emailService;

    @Override
    public void contactUs(UserContact userContact){

        EmailDomain emailDomain = new EmailDomain();
        emailDomain.setFrom(userContact.getEmail());
        emailDomain.setTo(BasicConstants.EMAIL_TO);
        emailDomain.setComment(userContact.getComment());
        emailService.sendMail(emailDomain);

        basicDao.save(userContact);
    }
}
