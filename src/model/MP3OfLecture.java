package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_mp3_of_lecture")
public class MP3OfLecture extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "mp3_id")
    private MP3 mp3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "lecture_id")
    @JsonIgnore
    private Lecture lecture;

    @Column(nullable = false)
    private Boolean isComplete;

    public MP3 getMp3() {
        return mp3;
    }

    public void setMp3(MP3 mp3) {
        this.mp3 = mp3;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }
}
