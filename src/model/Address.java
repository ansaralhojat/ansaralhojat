package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADDRESS")
public class Address extends BaseModel {
    private String addressInfo;
    private boolean family;
    private boolean parking;

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
}
