package model;

import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.List;

@Entity
@Subselect(value = "SELECT\n" +
        "  1                                    AS id,\n" +
        "  (SELECT t.abstractText\n" +
        "   FROM tb_text_ t\n" +
        "   ORDER BY t.id DESC\n" +
        "   LIMIT 1)                            AS lastAbstractText,\n" +
        "  (SELECT max(f.id)\n" +
        "   FROM tb_fun_ f)                     AS fun_id,\n" +
        "  (SELECT max(f.id)\n" +
        "   FROM tb_fun_ f\n" +
        "   WHERE f.id NOT IN (SELECT max(f.id)\n" +
        "                      FROM tb_fun_ f)) AS another_fun_id,\n" +
        "  (SELECT a.id\n" +
        "   FROM tb_address_ a\n" +
        "   LIMIT 1)                            AS address_id,\n" +
        "  (SELECT m.date\n" +
        "   FROM tb_lecture_ l\n" +
        "     JOIN tb_meeting_ m ON m.id = l.meeting_id\n" +
        "   ORDER BY l.id DESC\n" +
        "   LIMIT 1)                            AS lastLectureDate,\n" +
        "  (SELECT c.name\n" +
        "   FROM tb_clip_ c\n" +
        "   ORDER BY c.id DESC\n" +
        "   LIMIT 1)                            AS lastUpdatedClipName,\n" +
        "  (SELECT m.date AS lastUpdatedPictureDate\n" +
        "   FROM tb_picture_ p\n" +
        "     JOIN tb_meeting_ m ON m.id = p.meeting_id\n" +
        "   ORDER BY p.id DESC\n" +
        "   LIMIT 1)                            AS lastUpdatedPictureDate\n" +
        "FROM dual")
public class Index extends BaseModel {

    private String lastAbstractText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fun_id")
    private Fun fun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "another_fun_id")
    private Fun anotherFun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    private String lastLectureDate;

    private String lastUpdatedClipName;

    private String lastUpdatedPictureDate;

    public List<Fun> getFuns() {
        return Arrays.asList(fun, anotherFun);
    }

    public String getLastAbstractText() {
        return lastAbstractText;
    }

    public void setLastAbstractText(String lastAbstractText) {
        this.lastAbstractText = lastAbstractText;
    }

    public Fun getFun() {
        return fun;
    }

    public void setFun(Fun fun) {
        this.fun = fun;
    }

    public Fun getAnotherFun() {
        return anotherFun;
    }

    public void setAnotherFun(Fun anotherFun) {
        this.anotherFun = anotherFun;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLastLectureDate() {
        return lastLectureDate;
    }

    public void setLastLectureDate(String lastLectureDate) {
        this.lastLectureDate = lastLectureDate;
    }

    public String getLastUpdatedClipName() {
        return lastUpdatedClipName;
    }

    public void setLastUpdatedClipName(String lastUpdatedClipName) {
        this.lastUpdatedClipName = lastUpdatedClipName;
    }

    public String getLastUpdatedPictureDate() {
        return lastUpdatedPictureDate;
    }

    public void setLastUpdatedPictureDate(String lastUpdatedPictureDate) {
        this.lastUpdatedPictureDate = lastUpdatedPictureDate;
    }
}
