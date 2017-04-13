package model;

import javax.persistence.*;

@Entity
@Table(name = "tb_fun_")
@NamedQuery(name = "findBySubject", query = "select f from Fun f where f.subject = ?1")

public class Fun extends BaseModel {
    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String pictureAddress;

    @Lob
    @Column(nullable = false)
    private String introduction;

    @Lob
    @Column(nullable = false)
    private String context;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
