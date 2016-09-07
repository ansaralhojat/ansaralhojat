package webBean;

import model.Fun;
import sessionFacadeBean.FunService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class FunWebBean implements Serializable {

    @EJB
    private FunService funService;

    private List<Fun> funs = new ArrayList<Fun>();

    private Fun selectedFun;

    @ManagedProperty(value="#{param.subject}")
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @PostConstruct
    public void init() {
        if (subject!=null)
            selectedFun = funService.findBySubject(subject);
        else
            funs = funService.findAllOrderById(Fun.class, false);
   }

    public String back() {
        selectedFun = null;
        return "fun";
    }

    public List<Fun> getFuns() {
        return funs;
    }

    public Fun getSelectedFun() {
        return selectedFun;
    }

    public void setSelectedFun(Fun selectedFun) {
        this.selectedFun = selectedFun;
    }

}
