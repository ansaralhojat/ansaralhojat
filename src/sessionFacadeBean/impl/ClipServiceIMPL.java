package sessionFacadeBean.impl;

import model.Clip;
import sessionFacadeBean.ClipService;

import javax.ejb.Stateless;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Stateless
public class ClipServiceIMPL extends BaseServiceIMPL<Clip> implements ClipService {

    @Override
    protected void addJoinFetch(Root<Clip> from) {
        from.fetch("mp3", JoinType.LEFT);
    }
}