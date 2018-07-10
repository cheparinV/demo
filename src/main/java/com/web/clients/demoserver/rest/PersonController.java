package com.web.clients.demoserver.rest;

import com.web.clients.demoserver.db.model.Person;
import com.web.clients.demoserver.db.repository.PersonRepository;
import com.web.clients.demoserver.dto.ErrorDto;
import com.web.clients.demoserver.dto.PersonDto;
import com.web.clients.demoserver.dto.PersonDtoWithPictureURI;
import com.web.clients.demoserver.dto.PersonRegistrationDto;
import com.web.clients.demoserver.service.PersonService;
import com.web.clients.demoserver.service.model.PersonWrapperWithPictureURI;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repository;
    private final ModelMapper mapper;
    private final PersonService service;

    @Autowired
    public PersonController(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @ApiOperation("Get person by id")
    @GetMapping
    public PersonDto getPersonById(@RequestParam("id") Long id) {
        return this.mapper.map(
                this.service.getPersonWithRating(id), PersonDto.class);
    }

    @ApiOperation("Get all persons")
    @GetMapping("/all")
    public List<PersonDto> getAllPersons() {
        return this.service.getAllPersonsWithRating()
                .stream()
                .map(wrapper -> this.mapper.map(wrapper, PersonDto.class))
                .collect(Collectors.toList());
    }


    @ApiOperation("registration for new person")
    @PostMapping
    public Long registerPerson(@RequestBody PersonRegistrationDto dto) {
        final Person person = mapper.map(dto, Person.class);
        return service.addPerson(person).getId();
    }

    @ApiOperation("Load picture for user")
    @PostMapping("/picture")
    public PersonDtoWithPictureURI uploadPicture(@RequestParam("id") Long id,
                                @RequestParam("file") MultipartFile file) {
        final PersonWrapperWithPictureURI personWithPicture = this.service.addPictureByPerson(id, file);
        return this.mapper.map(personWithPicture, PersonDtoWithPictureURI.class);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handler(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDto().setCode("400").setMessage(ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
