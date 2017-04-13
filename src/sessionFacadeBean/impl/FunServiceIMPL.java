package sessionFacadeBean.impl;

import model.Fun;
import sessionFacadeBean.FunService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FunServiceIMPL extends BaseServiceIMPL<Fun> implements FunService {

    @Override
    public List<Fun> findAllLimited(int number) {
        return findAllOrderById(Fun.class, false).subList(0, 2);
    }

    @Override
    public Fun findBySubject(String subject) {
        return (Fun) entityManager.createNamedQuery("findBySubject").setParameter(1, subject)
                .getSingleResult();
    }
}