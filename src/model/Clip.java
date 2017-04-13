package model;

import javax.persistence.*;

@Entity
@Table(name = "tb_clip_")
public class Clip extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "mp3_id")
    private MP3 mp3;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pictureAddress;

    public MP3 getMp3() {
        return mp3;
    }

    public void setMp3(MP3 mp3) {
        this.mp3 = mp3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}
