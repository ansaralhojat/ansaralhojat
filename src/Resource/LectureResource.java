package Resource;

import model.Lecture;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import sessionFacadeBean.LectureService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lectures")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@RequestScoped
public class LectureResource {
    @EJB
    private LectureService lectureService;

    @GET
    public List<Lecture> getLectures() {
        return lectureService.findAllOrderById(Lecture.class, false);
    }

}
