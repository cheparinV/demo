package com.web.clients.demoserver.service.model;

import com.web.clients.demoserver.db.model.Person;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public class PersonWrapperWithPictureURI {

    private Person person;
    private String uri;

    public Person getPerson() {
        return person;
    }

    public PersonWrapperWithPictureURI setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public PersonWrapperWithPictureURI setUri(String uri) {
        this.uri = uri;
        return this;
    }
}
