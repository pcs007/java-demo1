package com.cen.springbootdemo.dao;

import com.cen.springbootdemo.web.domain.UserContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class BasicDaoImpl implements BasicDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * TABLE Design for Oracle
     * USER_CONTACT
     * varchar(100) ID
     * varchar(20) USER_NAME
     * varchar(100) COMPANY
     * varchar(100) EMAIL
     * varchar(100) COMMENT
     * TIMESTAMP    LAST_UPDATED_TIME
     */

    @Override
    public void save(UserContact userContact) {
        String sql = "INSERT INTO USER_CONTACT (ID,USER_NAME,COMPANY,EMAIL,COMMENT,LAST_UPDATED_TIME) values(?,?,?,?,?)";
        String id = "45234234234242";//this place mock a increase and not duplicated id
        jdbcTemplate.update(sql, id, userContact.getName(),userContact.getCompany(),userContact.getEmail(),
                userContact.getComment(),new Timestamp(System.currentTimeMillis()));
    }
}
