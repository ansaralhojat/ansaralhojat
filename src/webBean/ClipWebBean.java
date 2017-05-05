package webBean;

import model.Clip;
import sessionFacadeBean.ClipService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ClipWebBean implements Serializable {

    @EJB
    private ClipService clipService;

    List<model.Clip> clips = new ArrayList<Clip>();

    @PostConstruct
    public void init() {
        clips = clipService.findAllOrderById(Clip.class, false);
    }

    public List<model.Clip> getClips() {
        return clips;
    }
}
