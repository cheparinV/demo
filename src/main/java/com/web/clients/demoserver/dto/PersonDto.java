package com.web.clients.demoserver.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {

    private Long id;
    private String username;
    private Long age;
    private String mail;
    private Integer rating;

    public Long getId() {
        return id;
    }

    public PersonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PersonDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public PersonDto setAge(Long age) {
        this.age = age;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public PersonDto setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public PersonDto setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", rating=" + rating +
                '}';
    }
}
