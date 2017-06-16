package baseInfo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.faces.model.SelectItem;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Lecturer {
    HEYDARY_ZARE(0, "استاد حیدری زارع", "http://ansaralhojat.com:8080/image/lecture/heydari.jpeg"),
    SEYYED_HOSEINI(1, "حجه الاسلام حسینی", "http://ansaralhojat.com/resource/image/seyyed_hoseini.jpg"),
    BIGDELOO(2, "حجه الاسلام بیگدلو", "http://ansaralhojat.com:8080/image/lecture/bigdeli.jpg"),
    FEIZ(3, "حجه الاسلام فیض", "http://ansaralhojat.com:8080/image/lecture/seyyed_feiz.jpg"),
    ESMAEILI(4, "حجه الاسلام اسماعیلی", "http://ansaralhojat.com:8080/image/lecture/esmaeely.jpg"),
    MANSOORI(5, "حجه الاسلام منصوری", "http://ansaralhojat.com:8080/image/lecture/nopic.jpg"),
    EFTEKHARI(6, "حجه الاسلام افتخاری", "http://ansaralhojat.com:8080/image/lecture/nopic.jpg");

    private int id;
    private String title;
    private String pictureAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    Lecturer(int id, String title, String pictureAddress) {
        this.id = id;
        this.title = title;
        this.pictureAddress = pictureAddress;
    }

    public static Lecturer findById(int id) {
        for (Lecturer lecturer : Lecturer.values()) {
            if (lecturer.getId() == id)
                return lecturer;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Lecturer.values().length];
        int i = 0;
        for (Lecturer e : Lecturer.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
