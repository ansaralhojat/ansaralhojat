package sessionFacadeBean.impl;

import model.BaseModel;
import model.Person;
import model.Question;
import sessionFacadeBean.BaseService;
import sessionFacadeBean.QuestionService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class QuestionServiceIMPL extends BaseServiceIMPL<Question> implements QuestionService {

    @Override
    public List<Question> findAllQuestionWithResolveOrderByDateDesc() {
        Query query = entityManager.createQuery("select q from Question q where q.resolve is not null order by q.date desc ");
        return query.getResultList();
    }
}