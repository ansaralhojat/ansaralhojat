package model;

import baseInfo.Quality;
import baseInfo.converter.QualityConverter;

import javax.persistence.*;

@Entity
@Table(name = "tb_mp3_")
public class MP3 extends BaseModel {
    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private Float size;

    @Column(nullable = false)
    private Float duration;

    @Enumerated
    @Convert(converter = QualityConverter.class)
    private Quality quality;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
