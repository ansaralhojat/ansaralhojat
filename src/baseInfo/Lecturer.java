package baseInfo;

import javax.faces.model.SelectItem;

public enum Lecturer {
    HEYDARY_ZARE(0, "استاد حیدری زارع"),
    SEYYED_HOSEINI(1, "حجه الاسلام حسینی"),
    BIGDELOO(2, "حجه الاسلام بیگدلو"),
    FEIZ(3, "حجه الاسلام فیض"),
    ESMAEILI(4, "حجه الاسلام اسماعیلی"),
    MANSOORI(5, "حجه الاسلام منصوری");

    private int id;
    private String title;

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

    Lecturer(int id, String title) {
        this.id = id;
        this.title = title;
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
        for(Lecturer e: Lecturer.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
