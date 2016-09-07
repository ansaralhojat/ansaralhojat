package baseInfo;

import javax.faces.model.SelectItem;

public enum Roze {

    HAZRATE_ZAHRA(0, "حضرت زهرا سلام الله علیها");

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

    Roze(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Roze findById(int value) {
        for (Roze roze : Roze.values()) {
            if (roze.getId() == value)
                return roze;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Roze.values().length];
        int i = 0;
        for(Roze e: Roze.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
