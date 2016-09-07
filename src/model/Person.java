package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_PERSON")
public class Person extends BaseModel {
    private String name;
    private String family;
    private String mobilePhone;
    private String eMail;
    @Lob
    private String picture;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    private List<QoranFile> qoranFiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<QoranFile> getQoranFiles() {
        return qoranFiles;
    }

    public void setQoranFiles(List<QoranFile> qoranFiles) {
        this.qoranFiles = qoranFiles;
    }
}
