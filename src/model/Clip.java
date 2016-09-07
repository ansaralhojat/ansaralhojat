package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "TB_CLIP")
public class Clip extends BaseModel {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clip")
    private Set<File> file;

    private String name;

    private String picturePath;

    public Set<File> getFile() {
        return file;
    }

    public void setFile(Set<File> file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
