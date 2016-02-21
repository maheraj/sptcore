package com.spt.core.dao;

import com.spt.core.model.Person;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

/**
 * BDRent
 * User: maheraj
 * Date: 9/16/2015
 */
public class PersonDao implements IPersonDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    @Transactional
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }

    @Override
    @Transactional
    public Person findByID(long id) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Person.class);
        criteria.add(Restrictions.eq("id", id));
        return (Person) criteria.uniqueResult();
    }
}
