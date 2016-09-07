package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_QUESTION")
public class Question extends BaseModel{

    private Date date;
    private String subject;
    private String question;
    private String mobilePhone;
    private String eMail;
    @OneToOne
    private Resolve resolve;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Resolve getResolve() {
        return resolve;
    }

    public void setResolve(Resolve resolve) {
        this.resolve = resolve;
    }

}
