package baseInfo;

import javax.faces.model.SelectItem;

public enum Quality {
    LOW(0, "کم"), MEDIUM(1, "متوسط"), HIGH(2, "زیاد");
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

    Quality(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Quality findById(int id) {
        for (Quality quality : Quality.values()) {
            if (quality.getId() == id)
                return quality;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Quality.values().length];
        int i = 0;
        for (Quality e : Quality.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
