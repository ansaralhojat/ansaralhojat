package sessionFacadeBean;

import model.Lecture;

import java.util.List;

public interface LectureService extends BaseService<Lecture> {

    Lecture findLastLecture();

    List<Lecture> findByCondition(String subject, int lecturer, int decorum);

}
