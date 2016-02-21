package com.spt.core.dao;

import com.spt.core.model.Person;

/**
 * BDRent
 * User: maheraj
 * Date: 9/16/2015
 */
public interface IPersonDao {
    void save(Person person);

    void update(Person person);

    void delete(Person person);

    Person findByID(long id);
}
