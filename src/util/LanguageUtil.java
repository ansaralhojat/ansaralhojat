package util;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Singleton;
import java.util.ResourceBundle;

@ManagedBean
@ApplicationScoped
public class LanguageUtil {

    public static String getValue(String key) {
        try {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message.message");
        return resourceBundle.getString(key);
        } catch (Exception e) {
            return null;
        }
    }

}
