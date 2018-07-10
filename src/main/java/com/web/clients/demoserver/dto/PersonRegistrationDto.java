package com.web.clients.demoserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRegistrationDto {

    private String username;
    private Long age;
    private String mail;

    public String getUsername() {
        return username;
    }

    public PersonRegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public PersonRegistrationDto setAge(Long age) {
        this.age = age;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public PersonRegistrationDto setMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        return "PersonRegistrationDto{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                '}';
    }
}
