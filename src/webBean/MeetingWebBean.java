package webBean;

import model.Meeting;
import model.Picture;
import sessionFacadeBean.MeetingService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ManagedBean
@RequestScoped
public class MeetingWebBean implements Serializable {

    @EJB
    private MeetingService meetingService;

    private List<Meeting> meetings = new ArrayList<>();

    private Meeting selectedMeeting;

    @ManagedProperty(value = "#{param.loadedId}")
    private Long loadedId;

    @PostConstruct
    public void init() {
        if (loadedId == null)
            meetings = meetingService.findAllWithPictureOrderByDateDesc();
        else
            selectedMeeting = meetingService.findById(Meeting.class, loadedId);
    }

    public List<Picture> convertSetToList(Set<Picture> pictures) {
        return new ArrayList<>(pictures);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public Meeting getSelectedMeeting() {
        return selectedMeeting;
    }

    public Long getLoadedId() {
        return loadedId;
    }

    public void setLoadedId(Long loadedId) {
        this.loadedId = loadedId;
    }
}
