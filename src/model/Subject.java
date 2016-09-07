package model;

import javax.persistence.*;

@Entity
@Table(name = "TB_SUBJECT")
public class Subject extends BaseModel {

    private String Subject;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
