package sessionFacadeBean.impl;

import model.Fun;
import sessionFacadeBean.FunService;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class FunServiceIMPL extends BaseServiceIMPL<Fun> implements FunService{

    @Override
    public List findAllRestricted(int number) {
        String queryString = "select f from Fun f order by f.id desc";
        Query query = entityManager.createQuery(queryString);
        query.setMaxResults(number);
        return query.getResultList();
    }

    @Override
    public Fun findBySubject(String subject)  {
        String queryString = "select f from Fun f where f.funSubject = :funSubject";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("funSubject", subject);
        return (Fun) query.getSingleResult();
    }

}