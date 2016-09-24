package sessionFacadeBean.impl;

import baseInfo.Decorum;
import baseInfo.Lecturer;
import model.Lecture;
import sessionFacadeBean.LectureService;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class LectureServiceIMPL extends BaseServiceIMPL<Lecture> implements LectureService{

    @Override
    public Lecture findLastLecture() {
        String queryString = "select l from Lecture l order by l.id desc";
        Query query = entityManager.createQuery(queryString).setMaxResults(1);
        return (Lecture) query.getSingleResult();
    }

    @Override
    public List<Lecture> findByCondition(String subject, int lecturer, int decorum) {
        StringBuilder queryString =  new StringBuilder(" select l from Lecture l where 1=1 ");
        if (subject!=null && !subject.isEmpty()) queryString.append(" and l.masterSubject like :subject or l.slaveSubject like  :subject");
        if (lecturer >= 0) queryString.append(" and l.lecturer = :lecturer ");
        if (decorum >= 0) queryString.append(" and l.decorum = :decorum ");
        queryString.append(" order by l.id desc ");

        Query query = entityManager.createQuery(queryString.toString());
        if (subject!=null && !subject.isEmpty()) query.setParameter("subject", "%"+subject.trim()+"%");
        if (lecturer >= 0) query.setParameter("lecturer", Lecturer.findById(lecturer));
        if (decorum >= 0) query.setParameter("decorum", Decorum.findById(decorum));

        return query.getResultList();
    }

}