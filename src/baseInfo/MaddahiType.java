package baseInfo;

import javax.faces.model.SelectItem;

public enum MaddahiType {

    ROZE(0, "روضه"), ZAMINEH(1, "زمینه"), MOLOODI_SOROOD(2, "مولودی (سرود)"), MOLOODI_POEM(3, "مولودی (شعر)");

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

    MaddahiType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static MaddahiType findById(int value) {
        for (MaddahiType maddahiType : MaddahiType.values()) {
            if (maddahiType.getId() == value)
                return maddahiType;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[MaddahiType.values().length];
        int i = 0;
        for(MaddahiType e: MaddahiType.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
