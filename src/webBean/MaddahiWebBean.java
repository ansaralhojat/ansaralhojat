package webBean;

import baseInfo.Quality;
import model.File;
import model.Maddahi;
import sessionFacadeBean.BaseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class MaddahiWebBean implements Serializable {

    @EJB
    private BaseService<Maddahi> maddahiService;

    List<Maddahi> maddahis = new ArrayList<Maddahi>();

    public File getLowQuality(Maddahi maddahi) {
        for (File file : maddahi.getFile()) {
            if (file.getQuality().getId()== Quality.LOW.getId()) {
                return file;
            }
        }
        return null;
    }

    public File getHighQuality(Maddahi maddahi) {
        for (File file : maddahi.getFile()) {
            if (file.getQuality().getId()== Quality.HIGH.getId()) {
                return file;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        maddahis = maddahiService.findAllOrderById(Maddahi.class, false, "file");
   }

    public List<Maddahi> getMaddahis() {
        return maddahis;
    }

    public void setMaddahis(List<Maddahi> maddahis) {
        this.maddahis = maddahis;
    }
}
