package webBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

@ManagedBean
@SessionScoped
public class I18nL10nHelper implements Serializable {
    public static final String LANGUAGE = "language";

    @ManagedProperty(value = "#{param.language}")
    private String language;

    public Locale getLocale() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        if (!sessionMap.containsKey(LANGUAGE)) {
            Locale farsiLocal = new Locale("fa");
            sessionMap.put(LANGUAGE, farsiLocal);
            return farsiLocal;
        }

        if (getLanguage() != null) {
            Locale locale = new Locale(language);
            sessionMap.put(LANGUAGE, locale);
            return locale;
        }


        return (Locale) sessionMap.get(LANGUAGE);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
