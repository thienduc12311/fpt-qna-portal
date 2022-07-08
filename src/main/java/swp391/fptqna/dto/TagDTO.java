package swp391.fptqna.dto;

import java.util.Date;

public class TagDTO {
    private int id;
    private String tagName;
    private String description;
    private Date creationDate;
    private int ownUserId;

    private int questionCount;
    private byte state;

    public TagDTO(int id, String tagName, String description, Date creationDate, int ownUserId, int questionCount, byte state) {
        this.id = id;
        this.tagName = tagName;
        this.description = description;
        this.creationDate = creationDate;
        this.ownUserId = ownUserId;
        this.questionCount = questionCount;
        this.state = state;
    }

    public TagDTO(int id, String tagName){
        this.id = id;
        this.tagName = tagName;
    }

    public TagDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getOwnUserId() {
        return ownUserId;
    }

    public void setOwnUserId(int ownUserId) {
        this.ownUserId = ownUserId;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", ownUserId=" + ownUserId +
                ", questionCount=" + questionCount +
                ", state=" + state +
                '}';
    }
}
