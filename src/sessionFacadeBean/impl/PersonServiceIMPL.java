package sessionFacadeBean.impl;

import model.BaseModel;
import model.Person;
import sessionFacadeBean.BaseService;
import sessionFacadeBean.PersonService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonServiceIMPL extends BaseServiceIMPL<Person> implements PersonService{
    @Override
    public Person findByMobilePhone(String mobilePhone) {
        Query query = entityManager.createQuery("select p from Person p where p.mobilePhone = :mobilePhone");
        query.setParameter("mobilePhone", mobilePhone);
        List<Person> persons = query.getResultList();
        if (persons != null && persons.size() == 1)
            return persons.get(0);
        return null;
    }
}