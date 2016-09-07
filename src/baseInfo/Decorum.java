    package baseInfo;

    import javax.faces.model.SelectItem;

    public enum Decorum {
    HAFTEGI(0, "هفتگی"), MOHARRAM(1, "محرم"), SHAME_GHARIANE_HOSEINI(2, "شام غریبان حسینی"),
    TAVALODE_PEYGHAMBAR_ISLAM(3, "تولد پیامبر و امام جعفر صادق"), TAVALODE_HAZRATE_ZYNAB(4, "تولد حضرت زینب"),
    FATEMYEH(5, "فاطمیه"), VELADAT_HAZRATE_ZAHRA(6, "ولادت حضرت زهرا"), VAFAT_HAZRATE_ZEYNAB(7, "وفات حضرت زینب"), MABAATH(8, "عید مبعث"),
        TAVALOD_EMAM_HOSEIN(9, "تولد امام حسین"), TAVALODE_HAZRATE_ABBAS(10, "تولد حضرت عباس"), TAVALODE_EMAM_SAJJAV(11,"تولد امام سجاد"),
        TAVALODE_HAZRAE_ALIAKBAR(12, "ولادت حضرت علی اکبر"),
        NIME_SHABAN(13, "نیمه شعبان"),
        SHABE_GHADR(14, "شب های قدر"),
        SHAHADAT_EMEM_SADEGH(15, "شهادت امام صادق");

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

    Decorum(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static Decorum findById(int id) {
        for (Decorum decorum : Decorum.values()) {
            if (decorum.getId() == id)
                return decorum;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[Decorum.values().length];
        int i = 0;
        for(Decorum e: Decorum.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }

}
