package sessionFacadeBean;

import model.BaseModel;
import model.Question;

import java.util.List;

public interface QuestionService extends BaseService<Question> {

    public List<Question> findAllQuestionWithResolveOrderByDateDesc();

}
