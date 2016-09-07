package sessionFacadeBean;

import model.Meeting;

public interface MeetingService extends BaseService<Meeting> {

    Meeting findBySubject(String subject);

}
