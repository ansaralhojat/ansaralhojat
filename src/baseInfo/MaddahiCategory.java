package baseInfo;

import javax.faces.model.SelectItem;

public enum MaddahiCategory {

    ROZE(0, "مداحی"), MOLOODI(1, "مولودی");

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

    MaddahiCategory(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static MaddahiCategory findById(int value) {
        for (MaddahiCategory maddahiType : MaddahiCategory.values()) {
            if (maddahiType.getId() == value)
                return maddahiType;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[MaddahiCategory.values().length];
        int i = 0;
        for(MaddahiCategory e: MaddahiCategory.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
