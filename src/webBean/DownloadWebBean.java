package webBean;

import baseInfo.Quality;
import model.Lecture;
import model.MP3;
import model.MP3OfLecture;
import sessionFacadeBean.LectureService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class DownloadWebBean implements Serializable {
    @EJB
    private LectureService lectureService;

    private String subject;
    private int lecturer;
    private int decorum;

    List<Lecture> lectures = new ArrayList<>();

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

    public boolean hasCompleteMP3(Lecture lecture) {
        return lecture.getMp3OfLectures().stream().anyMatch(MP3OfLecture::getComplete);
    }

    public MP3 getAbstractMp3(Lecture lecture) {
        return lecture.getMp3OfLectures().stream().filter(p -> !p.getComplete()).map(MP3OfLecture::getMp3).findAny().orElse(null);
    }

    public MP3 getCompleteLowQualityMp3(Lecture lecture) {
        return lecture.getMp3OfLectures().stream().filter(p -> p.getComplete() && p.getMp3().getQuality().getId() == Quality.LOW.getId())
                .map(MP3OfLecture::getMp3).findAny().orElse(null);
    }

    public MP3 getCompleteMediumQualityMp3(Lecture lecture) {
        return lecture.getMp3OfLectures().stream().filter(p -> p.getComplete() && p.getMp3().getQuality().getId() == Quality.MEDIUM.getId())
                .map(MP3OfLecture::getMp3).findAny().orElse(null);
    }

    public MP3 getCompleteHighQualityMp3(Lecture lecture) {
        return lecture.getMp3OfLectures().stream().filter(p -> p.getComplete() && p.getMp3().getQuality().getId() == Quality.HIGH.getId())
                .map(MP3OfLecture::getMp3).findAny().orElse(null);
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
