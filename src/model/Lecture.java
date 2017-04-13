package model;

import baseInfo.Lecturer;
import baseInfo.converter.LecturerConverter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_lecture_")
@NamedQueries({
        @NamedQuery(name = "findLastLecture",
                query = "select distinct l from Lecture l " +
                        " left join fetch l.meeting " +
                        " left join fetch l.mp3OfLectures ml " +
                        " left join fetch ml.mp3 m " +
                        " left join fetch l.text " +
                        " where l.id = (select max(l.id) from Lecture l)")
})
public class Lecture extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private Set<MP3OfLecture> mp3OfLectures;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "text_id")
    private Text text;

    @Enumerated
    @Convert(converter = LecturerConverter.class)
    private Lecturer lecturer;

    @Column(nullable = false)
    private String masterSubject;

    private String slaveSubject;

    @Column(nullable = false)
    private Integer masterEpisode;

    @Column(nullable = false)
    private Integer slaveEpisode;

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public Set<MP3OfLecture> getMp3OfLectures() {
        return mp3OfLectures;
    }

    public void setMp3OfLectures(Set<MP3OfLecture> mp3OfLectures) {
        this.mp3OfLectures = mp3OfLectures;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getMasterSubject() {
        return masterSubject;
    }

    public void setMasterSubject(String masterSubject) {
        this.masterSubject = masterSubject;
    }

    public String getSlaveSubject() {
        return slaveSubject;
    }

    public void setSlaveSubject(String slaveSubject) {
        this.slaveSubject = slaveSubject;
    }

    public Integer getMasterEpisode() {
        return masterEpisode;
    }

    public void setMasterEpisode(Integer masterEpisode) {
        this.masterEpisode = masterEpisode;
    }

    public Integer getSlaveEpisode() {
        return slaveEpisode;
    }

    public void setSlaveEpisode(Integer slaveEpisode) {
        this.slaveEpisode = slaveEpisode;
    }

}