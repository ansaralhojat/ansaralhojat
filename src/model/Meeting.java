package model;

import baseInfo.Decorum;
import baseInfo.converter.DecorumConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_MEETING")
public class Meeting extends BaseModel {
    private Date date;

    private String Subject;

    @Enumerated
    @Convert(converter = DecorumConverter.class)
    private Decorum decorum;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meeting")
    List<MeetingPicture> meetingPictures;

    private String allPictureAddress;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public Decorum getDecorum() {
        return decorum;
    }

    public void setDecorum(Decorum decorum) {
        this.decorum = decorum;
    }

    public List<MeetingPicture> getMeetingPictures() {
        return meetingPictures;
    }

    public void setMeetingPictures(List<MeetingPicture> meetingPictures) {
        this.meetingPictures = meetingPictures;
    }

    public String getAllPictureAddress() {
        return allPictureAddress;
    }

    public void setAllPictureAddress(String allPictureAddress) {
        this.allPictureAddress = allPictureAddress;
    }
}
