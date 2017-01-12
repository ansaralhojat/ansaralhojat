package model;

import baseInfo.*;
import baseInfo.converter.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_FILE")
public class File extends BaseModel {
    private String path;

    @Enumerated
    @Convert(converter = FileTypeConverter.class)
    private FileType fileType;

    @Enumerated
    @Convert(converter = FileUsageConverter.class)
    private FileUsage fileUsage;

    @Enumerated
    @Convert(converter = FormatConverter.class)
    private FileFormat fileFormat;

    private Float size;

    private Float duration;

    @Enumerated
    @Convert(converter = FileDurationUnitConverter.class)
    private FileDurationUnit fileDurationUnit;

    @Enumerated
    @Convert(converter = QualityConverter.class)
    private Quality quality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lecture_id")
    Lecture lecture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maddahi_id")
    private Maddahi maddahi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clip_id")
    private Clip clip;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public FileUsage getFileUsage() {
        return fileUsage;
    }

    public void setFileUsage(FileUsage fileUsage) {
        this.fileUsage = fileUsage;
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
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

    public FileDurationUnit getFileDurationUnit() {
        return fileDurationUnit;
    }

    public void setFileDurationUnit(FileDurationUnit fileDurationUnit) {
        this.fileDurationUnit = fileDurationUnit;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Maddahi getMaddahi() {
        return maddahi;
    }

    public void setMaddahi(Maddahi maddahi) {
        this.maddahi = maddahi;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}