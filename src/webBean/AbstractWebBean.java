package webBean;

import model.Text;
import sessionFacadeBean.TextService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class AbstractWebBean implements Serializable {

    @EJB
    private TextService textService;

    private List<Text> texts = new ArrayList<>();

    private Text selectedText;

    @ManagedProperty(value = "#{param.loadedId}")
    private Long loadedId;

    @PostConstruct
    public void init() {
        if (loadedId != null)
            selectedText = textService.findById(Text.class, loadedId);
        else
            texts = textService.findAllOrderById(Text.class, false);
    }

    public String back() {
        selectedText = null;
        return "abstract";
    }

    public String getCompleteSubject(Text text) {
        return text.getLecture().getMasterSubject()
                + (text.getLecture().getSlaveSubject() == null ? "" : " - " + text.getLecture().getSlaveSubject());
    }

    public Long getLoadedId() {
        return loadedId;
    }

    public void setLoadedId(Long loadedId) {
        this.loadedId = loadedId;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public Text getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(Text selectedText) {
        this.selectedText = selectedText;
    }
}
