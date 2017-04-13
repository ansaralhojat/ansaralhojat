package sessionFacadeBean.impl;

import model.Meeting;
import sessionFacadeBean.MeetingService;

import javax.ejb.Stateless;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class MeetingServiceIMPL extends BaseServiceIMPL<Meeting> implements MeetingService {
    @Override
    public List<Meeting> findAllWithPictureOrderByDateDesc() {
        return entityManager.createNamedQuery("findAllWithPictureOrderByDateDesc").getResultList();
    }

    @Override
    protected void addJoinFetch(Root<Meeting> from) {
        from.fetch("pictures", JoinType.LEFT);
    }
}