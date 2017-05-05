package sessionFacadeBean.impl;

import model.Picture;
import sessionFacadeBean.PictureService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PictureServiceIMPL extends BaseServiceIMPL<Picture> implements PictureService {

    @Override
    public List<Picture> findByMeetingId(Long meetingId) {
        return entityManager.createNamedQuery("nq_picture_findByMeetingId").setParameter(1, meetingId).getResultList();
    }
}