package model;

import baseInfo.Decorum;
import baseInfo.Maddah;
import baseInfo.MaddahiType;
import baseInfo.Roze;
import baseInfo.converter.DecorumConverter;
import baseInfo.converter.MaddahConverter;
import baseInfo.converter.MaddahiTypeConverter;
import baseInfo.converter.RozeConverter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_MADDAHI")
public class Maddahi extends BaseModel {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "maddahi")
    private List<File> file;

    @Enumerated
    @Convert(converter = MaddahConverter.class)
    private Maddah maddah;

    @Enumerated
    @Convert(converter = MaddahiTypeConverter.class)
    private MaddahiType maddahiType;

    @Enumerated
    @Convert(converter = DecorumConverter.class)
    private Decorum decorum;

    @Enumerated
    @Convert(converter = RozeConverter.class)
    private Roze roze;

    private String farsiDate;

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

    public MaddahiType getMaddahiType() {
        return maddahiType;
    }

    public void setMaddahiType(MaddahiType maddahiType) {
        this.maddahiType = maddahiType;
    }

    public Decorum getDecorum() {
        return decorum;
    }

    public void setDecorum(Decorum decorum) {
        this.decorum = decorum;
    }

    public Roze getRoze() {
        return roze;
    }

    public void setRoze(Roze roze) {
        this.roze = roze;
    }

    public String getFarsiDate() {
        return farsiDate;
    }

    public void setFarsiDate(String farsiDate) {
        this.farsiDate = farsiDate;
    }
}