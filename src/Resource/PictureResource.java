package Resource;

import model.Picture;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import sessionFacadeBean.PictureService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("pictures")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class PictureResource {
    @EJB
    private PictureService pictureService;

    @GET
    public List<Picture> getLecture(@QueryParam("meetingId") long meetingId) {
        final List<Picture> pictures = pictureService.findByMeetingId(meetingId);
        return pictures;
    }

}
