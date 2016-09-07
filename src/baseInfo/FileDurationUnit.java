package baseInfo;

import javax.faces.model.SelectItem;

public enum FileDurationUnit {
    MINUTES(0, "fileDurationUnit.minutes");

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

    FileDurationUnit(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static FileDurationUnit findById(int id) {
        for (FileDurationUnit fileDurationUnit : FileDurationUnit.values()) {
            if (fileDurationUnit.getId() == id)
                return fileDurationUnit;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[FileDurationUnit.values().length];
        int i = 0;
        for(FileDurationUnit e: FileDurationUnit.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
