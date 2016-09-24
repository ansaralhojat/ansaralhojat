package model;

import baseInfo.FileUsage;
import baseInfo.converter.FileUsageConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "tb_text")
public class Text extends BaseModel {
    private Date date;

    @Lob
    private String text;

    private String abstractText;

    private String subjectText;

    @Enumerated
    @Convert(converter = FileUsageConverter.class)
    private FileUsage fileUsage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lecture_id")
    Lecture lecture;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getSubjectText() {
        return subjectText;
    }

    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    public FileUsage getFileUsage() {
        return fileUsage;
    }

    public void setFileUsage(FileUsage fileUsage) {
        this.fileUsage = fileUsage;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
