package sessionFacadeBean.impl;

import model.Lecture;
import model.Text;
import sessionFacadeBean.LectureService;
import sessionFacadeBean.TextService;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class TextServiceIMPL extends BaseServiceIMPL<Text> implements TextService{


    @Override
    public Text findBySubject(String subject) {
        final String queryString = "select t from Text t where (t.subject is not null and t.subject = :subject) " +
                "or (s.lecture is not null and (s.lecture.masterSubject) = :subject)" +
                "or (s.lecture is not null and (s.lecture.masterSubject||'-'||s.lecture.slaveSubject) = :subject";
        Query query = entityManager.createQuery(queryString).setParameter("subject", subject);
        return (Text) query.getSingleResult();
    }
}