package sessionFacadeBean;

import model.BaseModel;

import javax.ejb.Local;
import java.util.List;

public interface BaseService<T extends BaseModel> {

    void persist(T pojoPersistenceDomainModel);

    T merge(T pojoPersistenceDomainModel);

    void delete(T pojoPersistenceDomainModel);

    T findById(Class<T> clazz, Long id);

    List<T> findAllOrderById(Class<T> clazz, boolean asc);

}
