package Resource;

import model.Lecture;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import sessionFacadeBean.LectureService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/lectures")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class LectureResource {
    @EJB
    private LectureService lectureService;

    @GET
    public Lecture getLectures() {
        final Lecture lectures = lectureService.findLastLecture();
        return lectures;
    }

}
