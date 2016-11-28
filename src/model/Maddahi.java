package model;

import baseInfo.*;
import baseInfo.converter.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MADDAHI")
public class Maddahi extends BaseModel {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "maddahi")
    private List<File> file;

    @Enumerated
    @Convert(converter = MaddahConverter.class)
    private Maddah maddah;

    @Enumerated
    @Convert(converter = MaddahiCategoryConverter.class)
    private MaddahiCategory category;

    @Enumerated
    @Convert(converter = MaddahiTypeConverter.class)
    private MaddahiType type;

    @Enumerated
    @Convert(converter = DecorumConverter.class)
    private Decorum decorum;

    @Enumerated
    @Convert(converter = HugeConverter.class)
    private Huge huge;

    private String date;

    private String picturePath;

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public Maddah getMaddah() {
        return maddah;
    }

    public void setMaddah(Maddah maddah) {
        this.maddah = maddah;
    }

    public MaddahiCategory getCategory() {
        return category;
    }

    public void setCategory(MaddahiCategory category) {
        this.category = category;
    }

    public MaddahiType getType() {
        return type;
    }

    public void setType(MaddahiType type) {
        this.type = type;
    }

    public Decorum getDecorum() {
        return decorum;
    }

    public void setDecorum(Decorum decorum) {
        this.decorum = decorum;
    }

    public Huge getHuge() {
        return huge;
    }

    public void setHuge(Huge huge) {
        this.huge = huge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}