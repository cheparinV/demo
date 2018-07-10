package com.web.clients.demoserver.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private Integer age;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(nullable = false)
    private Integer rating = 0;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public Integer getRating() {
        return rating;
    }

    public Person setUsername(String username) {
        this.username = username;
        return this;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Person setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Person setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", rating=" + rating +
                '}';
    }
}
