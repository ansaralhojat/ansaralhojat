package webBean;

import model.Race;
import sessionFacadeBean.RaceService;
import util.GeneralUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@RequestScoped
public class RaceWebBean implements Serializable {

    @EJB
    RaceService raceService;
    @Inject
    private GeneralUtil generalUtil;

    private String name;
    private Long phoneNumber;
    private Integer questionNo;
    private String resolve;

    public void fireRace() {
        Race race = new Race();
        race.setName(this.name);
        race.setPhoneNumber(this.phoneNumber);
        race.setQuestionNo(this.questionNo);
        race.setResolve(this.resolve);
        race.setDate(new Date());
        raceService.persist(race);
        reset();
        generalUtil.addInfo("جواب سوال شما با موفقیت ارسال شد", null);
    }

    public void reset() {
        this.name=null;
        this.phoneNumber=null;
        this.questionNo=null;
        this.resolve=null;
    }

    @PostConstruct
    public void init() {
        reset();
    }

    public RaceService getRaceService() {
        return raceService;
    }

    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    public GeneralUtil getGeneralUtil() {
        return generalUtil;
    }

    public void setGeneralUtil(GeneralUtil generalUtil) {
        this.generalUtil = generalUtil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }
}
