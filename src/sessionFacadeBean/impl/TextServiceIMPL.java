package sessionFacadeBean.impl;

import model.Text;
import sessionFacadeBean.TextService;

import javax.ejb.Stateless;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Stateless
public class TextServiceIMPL extends BaseServiceIMPL<Text> implements TextService {

    @Override
    protected void addJoinFetch(Root<Text> from) {
        from.fetch("lectures", JoinType.LEFT);
    }

    @Override
    public Text findLastText() {
        return (Text) entityManager.createNamedQuery("findLastText").getSingleResult();
    }
}