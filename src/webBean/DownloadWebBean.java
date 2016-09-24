package webBean;

import baseInfo.FileUsage;
import baseInfo.Quality;
import model.File;
import model.Lecture;
import model.Text;
import sessionFacadeBean.LectureService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ManagedBean
@RequestScoped
public class DownloadWebBean implements Serializable {

    @EJB
    private LectureService lectureService;

    private String subject;
    private int lecturer;
    private int decorum;

    List<Lecture> lectures = new ArrayList<Lecture>();

    public String getAbstractText(Lecture lecture) {
        for (Text text : lecture.getText()) {
            if (text.getFileUsage().getId()== FileUsage.ABSTRACT_LECTURE.getId()) {
                return text.getText();
            }
        }
        return "موجود نیست";
    }

    public File getAbstractFile(Lecture lecture) {
        for (File file : lecture.getFile()) {
            if (file.getFileUsage().getId()== FileUsage.ABSTRACT_LECTURE.getId()) {
                return file;
            }
        }
        return null;
    }

    public File getCompleteFile(Lecture lecture) {
        for (File file : lecture.getFile()) {
            if (file.getFileUsage().getId()== FileUsage.COMPLETE_LECTURE.getId() && file.getQuality().getId()== Quality.LOW.getId()) {
                return file;
            }
        }
        return null;
    }

    public File getCompleteFileMD(Lecture lecture) {
        for (File file : lecture.getFile()) {
            if (file.getFileUsage().getId()== FileUsage.COMPLETE_LECTURE.getId() && file.getQuality().getId()== Quality.MEDIUM.getId()) {
                return file;
            }
        }
        return null;
    }

    public File getCompleteFileHD(Lecture lecture) {
        for (File file : lecture.getFile()) {
            if (file.getFileUsage().getId()== FileUsage.COMPLETE_LECTURE.getId() && file.getQuality().getId()== Quality.HIGH.getId()) {
                return file;
            }
        }
        return null;
    }

    public void search() {
        lectures = lectureService.findByCondition(subject, lecturer, decorum);
    }

    @PostConstruct
    public void init() {
        lectures = lectureService.findAllOrderById(Lecture.class, false);
        clearSearchFields();
   }

    public void clearSearchFields() {
        subject = null;
        lecturer = -1;
        decorum = -1;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLecturer(int lecturer) {
        this.lecturer = lecturer;
    }

    public int getLecturer() {
        return lecturer;
    }

    public void setDecorum(int decorum) {
        this.decorum = decorum;
    }

    public int getDecorum() {
        return decorum;
    }
}
