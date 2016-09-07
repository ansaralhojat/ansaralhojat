package webBean;

import model.Lecture;
import model.Text;
import sessionFacadeBean.LectureService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Set;

@ManagedBean
@SessionScoped
public class LastMeetingWebBean implements Serializable {

    @EJB
    private LectureService lectureService;

    private Lecture lastLecture;

    @PostConstruct
    public void init() {
        lastLecture = lectureService.findLastLecture();
    }

    public Lecture getLastLecture() {
        return lastLecture;
    }
}
