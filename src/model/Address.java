package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address_")
public class Address extends BaseModel {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String timeInfo;

    @Column(nullable = false)
    private String addressInfo;

    @Column(nullable = false)
    private boolean family;

    @Column(nullable = false)
    private boolean parking;

    @Column(nullable = false)
    private String qoranInfo;

    @Column(nullable = false)
    private String lectureInfo;

    @Column(nullable = false)
    private String maddahiInfo;

    private String additionalInformation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(String timeInfo) {
        this.timeInfo = timeInfo;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getQoranInfo() {
        return qoranInfo;
    }

    public void setQoranInfo(String qoranInfo) {
        this.qoranInfo = qoranInfo;
    }

    public String getLectureInfo() {
        return lectureInfo;
    }

    public void setLectureInfo(String lectureInfo) {
        this.lectureInfo = lectureInfo;
    }

    public String getMaddahiInfo() {
        return maddahiInfo;
    }

    public void setMaddahiInfo(String maddahiInfo) {
        this.maddahiInfo = maddahiInfo;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
