package com.web.clients.demoserver.service;

import com.web.clients.demoserver.db.model.Person;
import com.web.clients.demoserver.service.model.PersonWrapperWithPictureURI;
import com.web.clients.demoserver.service.model.PersonWrapperWithRating;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public interface PersonService {

    /**
     * Adding new {@link Person} to db and checking
     *
     * @param {@link Person} for adding
     * @return {@link Person} with id
     */
    Person addPerson(Person person);

    /**
     * Loading new picture by {@link Person} id
     *
     * @param id {@link Person} id
     * @param picture for loading
     * @return {@link Person} and picture's URI
     */
    PersonWrapperWithPictureURI addPictureByPerson(Long id, MultipartFile picture);

    /**
     * @param id {@link Person} id
     * @return {@link Person} with rating
     */
    PersonWrapperWithRating getPersonWithRating(Long id);

    /**
     * Like {@link PersonService#getPersonWithRating} for all {@link Person} in database.
     *
     * @return List of {@link Person} with rating
     */
    List<PersonWrapperWithRating> getAllPersonsWithRating();
}
