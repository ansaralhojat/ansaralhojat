package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_FUN")
public class Fun extends BaseModel {
    private Date date;

    private String funSubject;

//    @ManyToMany
//    @JoinTable(name = "TB_FUN_SUBJECT",
//        joinColumns = {@JoinColumn(name = "FUN_ID", referencedColumnName = "id")},
//        inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "id")})
//    private List<Subject> subject;

    private String pictureAddress;

    @Lob
    private String introFun;

    @Lob
    private String completeFun;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;

    }

    public String getFunSubject() {
        return funSubject;
    }

    public void setFunSubject(String funSubject) {
        this.funSubject = funSubject;
    }

//    public List<Subject> getSubject() {
//        return subject;
//    }
//
//    public void setSubject(List<Subject> subject) {
//        this.subject = subject;
//    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getIntroFun() {
        return introFun;
    }

    public void setIntroFun(String introFun) {
        this.introFun = introFun;
    }

    public String getCompleteFun() {
        return completeFun;
    }

    public void setCompleteFun(String completeFun) {
        this.completeFun = completeFun;
    }
}
