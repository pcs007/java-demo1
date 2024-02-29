package com.cen.springbootdemo.web;


import com.cen.springbootdemo.service.BasicService;
import com.cen.springbootdemo.web.domain.SuccessResp;
import com.cen.springbootdemo.web.domain.UserContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/v1/contact")
public class BasicController {

    @Autowired
    private BasicService basicService;


    @PostMapping("/contact-us")
    public SuccessResp contactUs(@RequestBody UserContact userContact) {

        String name = userContact.getName();
        String company = userContact.getCompany();
        String email = userContact.getEmail();
        String comment = userContact.getComment();

        if (null == name) {
            throw new IllegalArgumentException("name is required");
        }
        if (null == company) {
            throw new IllegalArgumentException("company is required");
        }
        if (null == email) {
            throw new IllegalArgumentException("email is required");
        }
        //valid email
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("email need valid");
        }
        if (null == comment) {
            throw new IllegalArgumentException("comment is required");
        }

        try {
            basicService.contactUs(userContact);
        } catch (Exception e) {
            return SuccessResp.FAILED;
        }
        return SuccessResp.SUCCESS;
    }
}
