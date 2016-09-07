package sessionFacadeBean;

import com.sun.istack.internal.NotNull;
import model.Fun;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FunService extends BaseService<Fun> {

    public List findAllRestricted(int number);

    public Fun findBySubject(String subject);

}
