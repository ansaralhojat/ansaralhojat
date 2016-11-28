package baseInfo;

import javax.faces.model.SelectItem;

public enum Huge {

    MONAJAT(0, "مناجات"),
    PAYAMBAR(1, ""),
    EMAM_ALI(2, ""),
    HAZRATE_ZAHRA(3, "حضرت زهرا سلام الله علیها"),
    EMAM_HASAN(4, "حضرت زهرا سلام الله علیها"),
    EMAM_HOSEIN(5, "امام حسین علیه السلام"),
    EMAM_SAJJAD(6, "حضرت زهرا سلام الله علیها"),
    EMAM_BAGHER(7, "حضرت زهرا سلام الله علیها"),
    EMAM_SADEGH(8, "حضرت زهرا سلام الله علیها"),
    EMAM_KAZEM(9, "حضرت زهرا سلام الله علیها"),
    EMAM_REZA(10, "حضرت زهرا سلام الله علیها"),
    EMAM_JAVAD(11, "حضرت زهرا سلام الله علیها"),
    EMAM_HADI(12, "حضرت زهرا سلام الله علیها"),
    EMAM_ASGARI(13, "حضرت زهرا سلام الله علیها"),
    EMAM_ZAMAN(14, "امام زمان عجل الله تعالی"),
    HAZRATE_ZEYNAB(15, "حضرت زینب سلام الله علیها"),
    DO_TEFLAN_ZEYNAB(16, "دو طفلان حضرت زینب");

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

    Huge(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Huge findById(int value) {
        for (Huge roze : Huge.values()) {
            if (roze.getId() == value)
                return roze;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Huge.values().length];
        int i = 0;
        for(Huge e: Huge.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
