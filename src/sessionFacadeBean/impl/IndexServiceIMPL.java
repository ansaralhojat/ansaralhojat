package sessionFacadeBean.impl;

import model.Index;
import sessionFacadeBean.IndexService;

import javax.ejb.Stateless;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Stateless
public class IndexServiceIMPL extends BaseServiceIMPL<Index> implements IndexService {

    @Override
    protected void addJoinFetch(Root<Index> from) {
        from.fetch("fun", JoinType.INNER);
        from.fetch("anotherFun", JoinType.INNER);
        from.fetch("address", JoinType.INNER);
    }
}