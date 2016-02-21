package com.spt.core.model;

import com.spt.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * BDRent
 * User: maheraj
 * Date: 10/23/2015
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String emailAddress;
    private String name;
    private String password;

    //metadata col
    private Date creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (StringUtils.isBlank(password)) {
            password = StringUtil.randomHighStrengthPassword(8);
        }
        this.password = DigestUtils.md5Hex(password);
    }
}
