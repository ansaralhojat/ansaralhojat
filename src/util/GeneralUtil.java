package util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
@Named
public class GeneralUtil {

    public String getIpAddress() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    public void addInfo(String masterMessage, String slaveMessage) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, masterMessage, slaveMessage);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getRandomEffect() {
        String[] effects = {"Blind", "Bounce", "Clip", "Drop", "Explode", "Fade", "Fold", "Highlight", "Puff", "Pulsate", "Scale", "Shake", "Size", "Slide", "Transfer"};
        int random = ThreadLocalRandom.current().nextInt(0, effects.length);
        if (random > effects.length)
            return effects[0];
        return effects[random];
    }

}
