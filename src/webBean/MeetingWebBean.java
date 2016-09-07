package webBean;

import model.Meeting;
import sessionFacadeBean.MeetingService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class MeetingWebBean implements Serializable {

    @EJB
    private MeetingService meetingService;

    private List<Meeting> meetings = new ArrayList<>();

    private Meeting selectedMeeting;

    @ManagedProperty(value="#{param.subject}")
    private String subject;

    @PostConstruct
    public void init() {
        if (subject == null)
            meetings = meetingService.findAllOrderById(Meeting.class, false);
        else
            selectedMeeting = meetingService.findBySubject(subject);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public Meeting getSelectedMeeting() {
        return selectedMeeting;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
