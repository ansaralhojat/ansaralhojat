package webBean;

import model.Address;
import model.Fun;
import sessionFacadeBean.BaseService;
import sessionFacadeBean.FunService;
import util.SEOUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class IndexWebBean implements Serializable {

    @EJB
    private FunService funService;
    @EJB
    private BaseService<Address> addressService;
    @Inject
    private SEOUtil seoUtil;

    List<Fun> funs = new ArrayList<Fun>();
    Address address = null;

    @ManagedProperty(value="#{param.id}")
    private Long id;

    @PostConstruct
    public void init() {
//        seoUtil.createXmlSiteMap();
        funs = funService.findAllRestricted(2);
        address = addressService.findAllOrderById(Address.class, true).get(0);
    }

    public List<Fun> getFuns() {
        return funs;
    }

    public Address getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
