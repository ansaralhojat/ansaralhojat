package model;

import baseInfo.Decorum;
import baseInfo.converter.DecorumConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_meeting_")
@NamedQuery(name = "findAllWithPictureOrderByDateDesc",
        query = "select distinct m from Meeting m join fetch m.pictures order by m.date desc")
public class Meeting extends BaseModel {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "meeting")
    @JsonIgnore
    Set<Picture> pictures;

    @Column(nullable = false)
    private String date;

    @Enumerated
    @Convert(converter = DecorumConverter.class)
    private Decorum decorum;

    private Short count;

    private String comment;

    @Formula(value = "(SELECT count(*) FROM tb_picture_ p WHERE p.meeting_id = id)")
    private Integer pictureCount;

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Decorum getDecorum() {
        return decorum;
    }

    public void setDecorum(Decorum decorum) {
        this.decorum = decorum;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getPictureCount() {
        return pictureCount;
    }

    public void setPictureCount(Integer pictureCount) {
        this.pictureCount = pictureCount;
    }
}
