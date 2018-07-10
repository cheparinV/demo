package com.web.clients.demoserver.db.repository;

import com.web.clients.demoserver.db.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladislav Cheparin (vladislav.cheparin.gdc@ts.fujitsu.com)
 * @version $Id$
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
