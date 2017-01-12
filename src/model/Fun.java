package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_FUN")
public class Fun extends BaseModel {
    private Date date;

    private String funSubject;

    private String funSubject_en;

    private String pictureAddress;

    @Lob
    private String introFun;

    @Lob
    private String introFun_en;

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

    public String getFunSubject_en() {
        return funSubject_en;
    }

    public void setFunSubject_en(String funSubject_en) {
        this.funSubject_en = funSubject_en;
    }

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

    public String getIntroFun_en() {
        return introFun_en;
    }

    public void setIntroFun_en(String introFun_en) {
        this.introFun_en = introFun_en;
    }

    public String getCompleteFun() {
        return completeFun;
    }

    public void setCompleteFun(String completeFun) {
        this.completeFun = completeFun;
    }
}
