package webBean;

import model.Question;
import sessionFacadeBean.QuestionService;
import util.GeneralUtil;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@RequestScoped
public class QuestionWebBean implements Serializable {

    @EJB
    private QuestionService questionService;

    @Inject
    private GeneralUtil generalUtil;

    List<Question> questionList = new ArrayList<Question>();

    private String subject;
    private String question;
    private String mobilePhone;
    private String eMail;

    public void fireQuestion() {
        Question question = new Question();
        question.setSubject(this.subject);
        question.setQuestion(this.question);
        question.setMobilePhone(this.mobilePhone);
        question.seteMail(this.eMail);
        question.setDate(new Date());
        questionService.persist(question);
        reset();
        generalUtil.addInfo("سوال شما با موفقیت ارسال شد. موفق باشید.", null);
    }

    public void reset() {
        this.subject=null;
        this.question=null;
        this.mobilePhone=null;
        this.eMail=null;
    }

    @PostConstruct
    public void init() {
        questionList = questionService.findAllQuestionWithResolveOrderByDateDesc();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}