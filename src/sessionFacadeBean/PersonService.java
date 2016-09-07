package sessionFacadeBean;

import model.BaseModel;
import model.Person;

import javax.persistence.Query;
import java.util.List;

public interface PersonService extends BaseService<Person> {

    public Person findByMobilePhone(String mobilePhone);

}
