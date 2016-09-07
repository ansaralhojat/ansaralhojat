package baseInfo;

import javax.faces.model.SelectItem;

public enum FileUsage {
    ABSTRACT_LECTURE(0, "fileDurationUnit.minutes"), COMPLETE_LECTURE(1, "");

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

    FileUsage(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static FileUsage findById(int id) {
        for (FileUsage fileUsage : FileUsage.values()) {
            if (fileUsage.getId() == id)
                return fileUsage;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[FileUsage.values().length];
        int i = 0;
        for(FileUsage e: FileUsage.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
