package baseInfo;

import javax.faces.model.SelectItem;

public enum Maddah {
    SEYYED_MOHAMMAD(0, "سید محمد سید میرزایی"), SYYED_OMID(1, "سید امید صفوی"), MINOOYEE(2, "کربلایی مهدی مینویی");

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

    Maddah(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Maddah findById(int id) {
        for (Maddah maddah : Maddah.values()) {
            if (maddah.getId() == id)
                return maddah;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Maddah.values().length];
        int i = 0;
        for(Maddah e: Maddah.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
