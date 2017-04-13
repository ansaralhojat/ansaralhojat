package sessionFacadeBean;

import model.Fun;

import java.util.List;

public interface FunService extends BaseService<Fun> {

    List<Fun> findAllLimited(int number);

    Fun findBySubject(String subject);

}
