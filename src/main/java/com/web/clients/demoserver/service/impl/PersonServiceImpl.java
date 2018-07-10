package com.web.clients.demoserver.service.impl;

import com.web.clients.demoserver.db.model.Person;
import com.web.clients.demoserver.db.repository.PersonRepository;
import com.web.clients.demoserver.exception.IncorrectPersonDataException;
import com.web.clients.demoserver.service.PersonService;
import com.web.clients.demoserver.service.PictureStorageService;
import com.web.clients.demoserver.service.model.PersonWrapperWithPictureURI;
import com.web.clients.demoserver.service.model.PersonWrapperWithRating;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final PictureStorageService storage;
    private final ModelMapper mapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, PictureStorageService storage) {
        this.repository = repository;
        this.storage = storage;
        this.mapper = new ModelMapper();
    }

    @Override
    public Person addPerson(Person person) {
        if (person.getAge() < 18) {
            throw new IncorrectPersonDataException("Age less than 18!");
        }
        try {
            return repository.save(person);
        } catch (Exception e) {
            throw new IncorrectPersonDataException(e.getMessage());
        }
    }

    @Override
    public PersonWrapperWithPictureURI addPictureByPerson(Long id, MultipartFile picture) {
        final Person person = this.getPersonById(id);
        final boolean exist = this.storage.isExistInStorage(picture.getOriginalFilename());
        final String filename = this.storage.upload(picture);
        if (!exist) {
            this.repository.save(
                    person.setRating(person.getRating() + 1));
        }
        return new PersonWrapperWithPictureURI()
                .setPerson(person)
                .setUri("/picture/" + filename);
    }

    @Override
    public PersonWrapperWithRating getPersonWithRating(Long id) {
        final Person person = this.getPersonById(id);
        final PersonWrapperWithRating wrapper = this.mapper.map(person, PersonWrapperWithRating.class);
        wrapper.setRating((double) person.getRating() * 100 / this.storage.getFilesCount());
        return wrapper;
    }

    @Override
    public List<PersonWrapperWithRating> getAllPersonsWithRating() {
        return this.repository.findAll().stream().map(
                person -> this.mapper.map(person, PersonWrapperWithRating.class)
                        .setRating((double) person.getRating() * 100 / this.storage.getFilesCount()))
                .collect(Collectors.toList());
    }

    private Person getPersonById(Long id) {
        return this.repository.findById(id).orElseThrow(() ->
                new IncorrectPersonDataException("Not found user by id:" + id));
    }
}
