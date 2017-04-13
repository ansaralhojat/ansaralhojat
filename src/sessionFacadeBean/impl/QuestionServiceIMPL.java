package sessionFacadeBean.impl;

import model.Question;
import sessionFacadeBean.QuestionService;

import javax.ejb.Stateless;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class QuestionServiceIMPL extends BaseServiceIMPL<Question> implements QuestionService {

    @Override
    public List<Question> findAllQuestionWithResolveOrderByDateDesc() {
        return entityManager.createNamedQuery("findAllQuestionWithResolveOrderByDateDesc").getResultList();
    }

    @Override
    protected void addJoinFetch(Root<Question> from) {
        from.fetch("resolve", JoinType.LEFT);
    }
}