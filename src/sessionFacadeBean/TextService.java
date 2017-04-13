package sessionFacadeBean;

import model.Text;

public interface TextService extends BaseService<Text> {

    Text findLastText();

}
