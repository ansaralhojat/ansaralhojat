package model;

import javax.persistence.*;

@Entity
@Table(name = "TB_MeetingPicture")
public class MeetingPicture extends BaseModel {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
    private String pictureAddress;
    private String alt;
    private String pictureDescription;

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }
}
