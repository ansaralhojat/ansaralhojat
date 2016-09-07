package webBean;

import model.Clip;
import model.File;
import sessionFacadeBean.BaseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ManagedBean
@SessionScoped
public class ClipWebBean implements Serializable {

    @EJB
    private BaseService<model.Clip> clipService;

    List<model.Clip> clips = new ArrayList<Clip>();

    @PostConstruct
    public void init() {
            clips = clipService.findAllOrderById(model.Clip.class, false, "file");
   }

    public File getAnyObjectOfStream(Set<File> files) {
        return files.stream().findAny().get();
    }

    public List<model.Clip> getClips() {
        return clips;
    }
}
