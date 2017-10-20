package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_picture_")
@NamedQuery(name = "nq_picture_findByMeetingId",
        query = "select p from Picture p where p.meeting.id = ?1")
public class Picture extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "meeting_id")
    @JsonIgnore
    private Meeting meeting;

    @Column
    private String original;

    @Column(nullable = false)
    private String thumbnail;

    @Column
    private String address;

    private String alt;

    private String description;

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
