package sessionFacadeBean;

import model.Question;

import java.util.List;

public interface QuestionService extends BaseService<Question> {

    List<Question> findAllQuestionWithResolveOrderByDateDesc();

}
