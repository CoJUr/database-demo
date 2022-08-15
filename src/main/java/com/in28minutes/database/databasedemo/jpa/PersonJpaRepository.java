package com.in28minutes.database.databasedemo.jpa;


//Repository and Transaction needed for JPA. when doing several updates at once, want all to succeed or all to fail

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {

    //connect to the db
    @PersistenceContext
    EntityManager entityManager; //all operations stored in a session are stored in the entity manager, which interfaces the persistence context

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
//        when want to update or insert, call merge. it knows whether the id is set or not. if already set,  it will try update. else it will insert
    }
}
