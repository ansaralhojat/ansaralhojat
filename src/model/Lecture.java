package model;

import baseInfo.Decorum;
import baseInfo.Lecturer;
import baseInfo.Roze;
import baseInfo.converter.DecorumConverter;
import baseInfo.converter.LecturerConverter;
import baseInfo.converter.RozeConverter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_LECTURE")
public class Lecture extends BaseModel {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lecture")
    private Set<File> file;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lecture")
    private Set<Text> text;

    @Enumerated
    @Convert(converter = LecturerConverter.class)
    private Lecturer lecturer;

    private String picturePath;

    private String masterSubject;

    private String slaveSubject;

    private Integer masterEpisode;

    private Integer slaveEpisode;

    @Enumerated
    @Convert(converter = DecorumConverter.class)
    private Decorum decorum;

    @Transient
    @Enumerated
    @Convert(converter = RozeConverter.class)
    private Roze roze;

    public Set<File> getFile() {
        return file;
    }

    public void setFile(Set<File> file) {
        this.file = file;
    }

    public Set<Text> getText() {
        return text;
    }

    public void setText(Set<Text> text) {
        this.text = text;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
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

    public Decorum getDecorum() {
        return decorum;
    }

    public void setDecorum(Decorum decorum) {
        this.decorum = decorum;
    }

    public Roze getRoze() {
        return roze;
    }

    public void setRoze(Roze roze) {
        this.roze = roze;
    }
}