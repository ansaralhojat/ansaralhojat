package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_question_")
@NamedQuery(name = "findAllQuestionWithResolveOrderByDateDesc",
        query = "select q from Question q left join fetch q.resolve where q.resolve is not null order by q.date desc")
public class Question extends BaseModel {
    @Column(nullable = false)
    private Date date;

    private String subject;

    @Column(nullable = false, length = 1001)
    private String question;

    private String mobilePhone;

    private String eMail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resolve_id")
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
