package baseInfo;

import javax.faces.model.SelectItem;

public enum FileFormat {

    MP3(0, "mp3");

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

    FileFormat(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static FileFormat findById(int value) {
        for (FileFormat fileFormat : FileFormat.values()) {
            if (fileFormat.getId() == value)
                return fileFormat;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[FileFormat.values().length];
        int i = 0;
        for(FileFormat e: FileFormat.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
