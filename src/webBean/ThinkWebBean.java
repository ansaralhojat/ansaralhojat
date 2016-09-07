package webBean;

import model.Think;
import sessionFacadeBean.BaseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ManagedBean
@RequestScoped
public class ThinkWebBean implements Serializable {

    @EJB
    private BaseService<Think> thinkService;

    private List<Think> thinks = new ArrayList<Think>();

    private Think selectedThink;

    @ManagedProperty(value="#{param.loadedId}")
    private Long loadedId;

    @PostConstruct
    public void init() {
        if (loadedId == null) {
            thinks = thinkService.findAllOrderById(Think.class, false);
        } else {
            selectedThink = thinkService.findById(Think.class, loadedId);
            selectedThink.setCount(Optional.ofNullable(selectedThink.getCount()).orElse(0L)+1);
            selectedThink = thinkService.merge(selectedThink);
        }
    }
    public String back() {
        selectedThink = null;
        return "think";
    }

    public List<Think> getThinks() {
        return thinks;
    }

    public void setThinks(List<Think> thinks) {
        this.thinks = thinks;
    }

    public Think getSelectedThink() {
        return selectedThink;
    }

    public void setSelectedThink(Think selectedThink) {
        this.selectedThink = selectedThink;
    }

    public Long getLoadedId() {
        return loadedId;
    }

    public void setLoadedId(Long loadedId) {
        this.loadedId = loadedId;
    }
}
