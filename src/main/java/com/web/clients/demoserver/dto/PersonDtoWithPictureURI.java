package com.web.clients.demoserver.dto;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public class PersonDtoWithPictureURI {
    private PersonDto person;
    private String uri;

    public PersonDto getPerson() {
        return person;
    }

    public PersonDtoWithPictureURI setPerson(PersonDto person) {
        this.person = person;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public PersonDtoWithPictureURI setUri(String uri) {
        this.uri = uri;
        return this;
    }
}
