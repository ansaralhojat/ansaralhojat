package Resource;

import model.Meeting;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import sessionFacadeBean.MeetingService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("meetings")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class MeetingResource {
    @EJB
    private MeetingService meetingService;

    @GET
    @Path("/withPicture")
    public List<Meeting> getMeeting() {
        return meetingService.findAllWithPictureOrderByDateDesc();
    }

    @GET
    @Path("/{id}")
    public Meeting getLecture(@PathParam("id") long id) {
        return meetingService.findById(Meeting.class, id);
    }

}
