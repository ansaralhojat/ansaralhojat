package baseInfo;

import javax.faces.model.SelectItem;

public enum FileType {

    MUSIC(0, "music"), VIDEO(1, "video"), DOCUMENT(2, "document");

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

    FileType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static FileType findById(int value) {
        for (FileType fileType : FileType.values()) {
            if (fileType.getId() == value)
                return fileType;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[FileType.values().length];
        int i = 0;
        for(FileType e: FileType.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
