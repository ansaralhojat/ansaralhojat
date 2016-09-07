package webBean;

import model.Person;
import sessionFacadeBean.PersonService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PersonWebBean implements Serializable {

    @EJB
    private PersonService personService;

    private String mobilePhone;
    private Person selectedPerson;


    public String findPerson() {
        selectedPerson = personService.findByMobilePhone(mobilePhone);
        if (selectedPerson == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("شماره شما در بانک اطلاعاتی ثبت نشده است"));
            return null;
        }
        return "qoran";
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
