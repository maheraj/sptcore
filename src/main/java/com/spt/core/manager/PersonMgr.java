package com.spt.core.manager;

import com.spt.core.dao.IPersonDao;
import com.spt.core.model.Person;

/**
 * BDRent
 * User: maheraj
 * Date: 9/16/2015
 */
public class PersonMgr implements IPersonMgr {

    private IPersonDao personDao;

    public void setPersonDao(IPersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(Person person) {
        personDao.delete(person);
    }

    public Person findByID(long id) {
        return personDao.findByID(id);
    }
}
