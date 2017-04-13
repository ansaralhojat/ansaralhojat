package webBean;

import model.Index;
import sessionFacadeBean.IndexService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class IndexWebBean implements Serializable {
    @EJB
    private IndexService indexService;

    Index index;

    @PostConstruct
    public void init() {
        index = indexService.findById(Index.class, 1L);
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }
}
