package util;

import model.Fun;
import model.Meeting;
import model.Text;
import model.Think;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sessionFacadeBean.BaseService;
import sessionFacadeBean.FunService;
import sessionFacadeBean.MeetingService;
import sessionFacadeBean.TextService;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Singleton
//@Named
public class SEOUtil {

    @Inject
    private FunService funService;
    @Inject
    private TextService textService;
    @Inject
    private MeetingService meetingService;
    @Inject
    private BaseService<Think> thinkService;

    public void createXmlSiteMap() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("urlset");
            doc.appendChild(rootElement);

            Consumer<String> addLoc = locUrl -> {
                //  url element
                Element url = doc.createElement("url");
                rootElement.appendChild(url);

                // location element
                Element location = doc.createElement("loc");
                location.appendChild(doc.createTextNode(locUrl));
                url.appendChild(location);
            };

            addLoc.accept("http://ansaralhojat.com/");

            addLoc.accept("http://ansaralhojat.com/download.xhtml");
            addLoc.accept("http://ansaralhojat.com/clip.xhtml");
            addLoc.accept("http://ansaralhojat.com/maddahi.xhtml");

            addLoc.accept("http://ansaralhojat.com/meeting.xhtml");
            List<Meeting> meetingList = meetingService.findAllOrderById(Meeting.class, true);
            final List<String> meetingSubjectList = meetingList.stream().map(Meeting::getSubject).collect(Collectors.toList());
            meetingSubjectList.forEach(meetingSubject -> addLoc.accept("http://ansaralhojat.com/gallery.xhtml?subject=" + meetingSubject));

            addLoc.accept("http://ansaralhojat.com/question.xhtml");
            addLoc.accept("http://ansaralhojat.com/resolve.xhtml");

            addLoc.accept("http://ansaralhojat.com/fun.xhtml");
            List<Fun> funList = funService.findAllOrderById(Fun.class, true);
            final List<String> funSubjectList = funList.stream().map(Fun::getFunSubject).collect(Collectors.toList());
            funSubjectList.forEach(funSubject -> addLoc.accept("http://ansaralhojat.com/fun.xhtml?subject=" + funSubject));

            addLoc.accept("http://ansaralhojat.com/abstract.xhtml");
            List<Text> textList = textService.findAllOrderById(Text.class, true);
            final List<Long> textIdList = textList.stream().map(Text::getId).collect(Collectors.toList());
            textIdList.forEach(textId -> addLoc.accept("http://ansaralhojat.com/abstract.xhtml?loadedId=" + textId));

            addLoc.accept("http://ansaralhojat.com/think.xhtml");
            List<Think> thinkList = thinkService.findAllOrderById(Think.class, true);
            final List<Long> thinkIdList = thinkList.stream().map(Think::getId).collect(Collectors.toList());
            thinkIdList.forEach(thinkId -> addLoc.accept("http://ansaralhojat.com/think.xhtml?loadedId=" + thinkId));


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/aliakbar/Desktop/cars.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
