package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_THINK")
public class Think extends BaseModel {

    private String question;
    private String completeResolve;
    private String resourceName;
    private String resourceLink;
    private Long count;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCompleteResolve() {
        return completeResolve;
    }

    public void setCompleteResolve(String completeResolve) {
        this.completeResolve = completeResolve;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
