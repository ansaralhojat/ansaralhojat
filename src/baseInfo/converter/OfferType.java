package baseInfo.converter;

import javax.faces.model.SelectItem;

public enum OfferType {
    QORAN(0, "سخنرانی"),
    LECTURE(1, "سخنرانی"),
    MADAHI(2, "مداحی و مولودی"),
    FARHANGI(3, "امور فرهنگی"),
    SITE(4, "وب سایت"),
    OTHER(5, "سایر"),
    ;
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

    OfferType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static OfferType findById(int id) {
        for (OfferType offerType : OfferType.values()) {
            if (offerType.getId() == id)
                return offerType;
        }
        return null;
    }

    public static SelectItem[] getSelectItemValues() {
        SelectItem[] items = new SelectItem[OfferType.values().length];
        int i = 0;
        for(OfferType e: OfferType.values()) {
            items[i++] = new SelectItem(e.getId(), e.getTitle());
        }
        return items;
    }
}
