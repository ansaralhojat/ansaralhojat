package sessionFacadeBean.impl;

import model.Meeting;
import sessionFacadeBean.MeetingService;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class MeetingServiceIMPL extends BaseServiceIMPL<Meeting> implements MeetingService{


    @Override
    public Meeting findBySubject(String subject) {
        final String queryString = "select m from Meeting m where m.Subject = :subject";
        Query query = entityManager.createQuery(queryString).setParameter("subject", subject);
        return (Meeting) query.getSingleResult();
    }
}