package sessionFacadeBean;

import model.Picture;

import java.util.List;

public interface PictureService extends BaseService<Picture> {

    List<Picture> findByMeetingId(Long meetingId);

}
