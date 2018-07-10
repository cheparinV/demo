package com.web.clients.demoserver.service.model;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public class PersonWrapperWithRating {

    private Long id;
    private String username;
    private Long age;
    private String mail;
    private Double rating = 0.0;

    public Long getId() {
        return id;
    }

    public PersonWrapperWithRating setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PersonWrapperWithRating setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public PersonWrapperWithRating setAge(Long age) {
        this.age = age;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public PersonWrapperWithRating setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public PersonWrapperWithRating setRating(Double rating) {
        this.rating = rating;
        return this;
    }
}
