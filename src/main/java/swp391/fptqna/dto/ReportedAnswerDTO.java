package swp391.fptqna.dto;

import java.util.Date;

public class ReportedAnswerDTO {
    private int id;
    private byte flagTypeId;
    private int answerId;
    private int ownerUserId;
    private Date creationDate;
    private byte state;
    private String description;

    public ReportedAnswerDTO() {
    }

    public ReportedAnswerDTO(int id, byte flagTypeId, int answerId, int ownerUserId, Date creationDate, byte state, String description) {
        this.id = id;
        this.flagTypeId = flagTypeId;
        this.answerId = answerId;
        this.ownerUserId = ownerUserId;
        this.creationDate = creationDate;
        this.state = state;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getFlagTypeId() {
        return flagTypeId;
    }

    public void setFlagTypeId(byte flagTypeId) {
        this.flagTypeId = flagTypeId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(int ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ReportedAnswerDTO{" +
                "id=" + id +
                ", flagTypeId=" + flagTypeId +
                ", answerId=" + answerId +
                ", ownerUserId=" + ownerUserId +
                ", creationDate=" + creationDate +
                ", state=" + state +
                ", description='" + description + '\'' +
                '}';
    }
}
