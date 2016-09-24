package sessionFacadeBean.impl;

import model.BaseModel;
import sessionFacadeBean.BaseService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
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
        StringBuilder queryString = new StringBuilder("select t from ").append(clazz.getSimpleName()).append(" t ");
        queryString.append(" where t.id = :id");
        Query query = entityManager.createQuery(queryString.toString());
        query.setParameter("id", id);
        return (T) query.getSingleResult();
    }

    @Override
    public List<T> findAllOrderById(Class<T> clazz, boolean asc) {
        StringBuilder queryString = new StringBuilder("select t from ").append(clazz.getSimpleName()).append(" t ");
        queryString.append(" order by t.id "+ (asc ? "asc":"desc"));
        Query query = entityManager.createQuery(queryString.toString());
        return query.getResultList();
    }

}