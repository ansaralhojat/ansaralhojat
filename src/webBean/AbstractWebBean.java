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
import java.util.Optional;
import java.util.stream.Collectors;

@ManagedBean
@RequestScoped
public class AbstractWebBean implements Serializable {

    @EJB
    private TextService textService;

    private List<Text> texts = new ArrayList<>();

    private Text selectedText;

    @ManagedProperty(value="#{param.loadedId}")
    private Long loadedId;

    public String getCompleteSubject(Text text) {
        final StringBuilder result = new StringBuilder();
        Optional.ofNullable(text.getLecture()).ifPresent(lecture -> {
            result.append(lecture.getMasterSubject());
            Optional.ofNullable(lecture.getSlaveSubject()).ifPresent(s -> result.append("-").append(lecture.getSlaveSubject()));
        });
        Optional.ofNullable(text.getSubjectText()).ifPresent(lecture -> result.append(text.getSubjectText()));
        return result.toString();
    }

    @PostConstruct
    public void init() {
        if (loadedId!=null)
            selectedText = textService.findById(Text.class, loadedId, "lecture");
        else
            texts = textService.findAllOrderById(Text.class, false, "lecture");
   }

    public String back() {
        selectedText = null;
        return "fun";
    }

    public Long getLoadedId() {
        return loadedId;
    }

    public void setLoadedId(Long loadedId) {
        this.loadedId = loadedId;
    }

    public List<Text> getTexts() {
        return texts.stream().filter(text -> Optional.ofNullable(text.getAbstractText()).isPresent()).collect(Collectors.toList());
    }

    public Text getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(Text selectedText) {
        this.selectedText = selectedText;
    }
}
