package sessionFacadeBean;

import model.Meeting;

import java.util.List;

public interface MeetingService extends BaseService<Meeting> {

    List<Meeting> findAllWithPictureOrderByDateDesc();
}
