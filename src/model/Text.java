package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_text_")
@NamedQuery(name = "findLastText",
        query = "select t from Text t where t.id = (select max(t.id) from Text t)")
public class Text extends BaseModel {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "text")
    @JsonIgnore
    private Set<Lecture> lectures;

    @Transient
    @JsonIgnore
    private Lecture lecture;

    @Column(nullable = false, length = 1001)
    private String abstractText;

    @Lob
    @Column(nullable = false)
    private String text;

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Lecture getLecture() {
        return lectures.stream().findAny().get();
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
