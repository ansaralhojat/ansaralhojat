package sessionFacadeBean.impl;

import model.Lecture;
import sessionFacadeBean.LectureService;

import javax.ejb.Stateless;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class LectureServiceIMPL extends BaseServiceIMPL<Lecture> implements LectureService {

    @Override
    public Lecture findLastLecture() {
        return (Lecture) entityManager.createNamedQuery("findLastLecture").getSingleResult();
    }

    @Override
    public List<Lecture> findByCondition(String subject, int lecturer, int decorum) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Lecture> query = builder.createQuery(Lecture.class);
        final Root<Lecture> from = query.from(Lecture.class);
        addJoinFetch(from);
        Set<Predicate> predicates = new HashSet<>();
        if (subject != null && !subject.isEmpty()) {
            final Predicate masterPredicate = builder.like(from.get("masterSubject"), subject);
            final Predicate slavePredicate = builder.like(from.get("slaveSubject"), subject);
            predicates.add(builder.or(masterPredicate, slavePredicate));
        }
        if (lecturer >= 0)
            predicates.add(builder.equal(from.get("lecturer"), lecturer));
        if (decorum >= 0)
            predicates.add(builder.equal(from.get("decorum"), decorum));

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        query.orderBy(builder.desc(from.get("id")));
        query.distinct(true);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    protected void addJoinFetch(Root<Lecture> from) {
        from.fetch("meeting", JoinType.LEFT);
        from.fetch("mp3OfLectures", JoinType.LEFT).fetch("mp3", JoinType.LEFT);
        from.fetch("text", JoinType.LEFT);
    }

    @Override
    protected List<Lecture> afterFindAll(List<Lecture> result) {
        return result.stream().distinct().collect(Collectors.toList());
    }
}