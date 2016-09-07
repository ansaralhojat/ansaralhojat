package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_QORAN_FILE")
public class QoranFile extends BaseModel{
    private Date date;
    private String path;
    private String subject;
    private String comment;
    private Integer sooreh;
    private Integer fromAyeh;
    private Integer toAyeh;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSooreh() {
        return sooreh;
    }

    public void setSooreh(Integer sooreh) {
        this.sooreh = sooreh;
    }

    public Integer getFromAyeh() {
        return fromAyeh;
    }

    public void setFromAyeh(Integer fromAyeh) {
        this.fromAyeh = fromAyeh;
    }

    public Integer getToAyeh() {
        return toAyeh;
    }

    public void setToAyeh(Integer toAyeh) {
        this.toAyeh = toAyeh;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
