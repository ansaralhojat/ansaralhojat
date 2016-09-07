package sessionFacadeBean;

import model.Lecture;
import model.Text;

public interface TextService extends BaseService<Text> {

    public Text findBySubject(String subject);

}
