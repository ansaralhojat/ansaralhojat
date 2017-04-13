package sessionFacadeBean.impl;

import model.BaseModel;
import sessionFacadeBean.BaseService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class BaseServiceIMPL<T extends BaseModel> implements BaseService<T> {

    @PersistenceContext(unitName = "ansaralhojatPU")
    public EntityManager entityManager;

    @Override
    public void persist(T pojoPersistenceDomainModel) {
        entityManager.persist(pojoPersistenceDomainModel);
    }

    @Override
    public T merge(T pojoPersistenceDomainModel) {
        return entityManager.merge(pojoPersistenceDomainModel);
    }

    @Override
    public void delete(T pojoPersistenceDomainModel) {
        entityManager.remove(entityManager.contains(pojoPersistenceDomainModel) ? pojoPersistenceDomainModel : entityManager.merge(pojoPersistenceDomainModel));
    }

    @Override
    public T findById(Class<T> clazz, Long id) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = builder.createQuery(clazz);
        final Root<T> from = query.from(clazz);
        addJoinFetch(from);
        query.where(builder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<T> findAllOrderById(Class<T> clazz, boolean asc) {
        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = builder.createQuery(clazz);
        final Root<T> from = query.from(clazz);
        addJoinFetch(from);
        final Order ascOrderBy = builder.asc(from.get("id"));
        final Order descOrderBy = builder.desc(from.get("id"));
        query.orderBy(asc ? ascOrderBy : descOrderBy);
        final List<T> result = entityManager.createQuery(query).getResultList();
        return afterFindAll(result);
    }

    protected void addJoinFetch(Root<T> from) {
    }

    protected List<T> afterFindAll(List<T> result) {
        return result;
    }

}