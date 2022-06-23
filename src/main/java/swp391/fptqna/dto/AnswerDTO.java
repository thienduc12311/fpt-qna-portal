package swp391.fptqna.dto;

import java.util.Date;

public class AnswerDTO {
    private int id;
    private int questionId;
    private Date creationDate;
    private Date deletionDate;
    private int score;
    private String body;
    private int ownerUserId;
    private int approveUserId;
    private int lastEditorUserId;
    private Date lastEditDate;
    private int commentCount;

    public AnswerDTO() {
    }

    public AnswerDTO(int id, int questionId, Date creationDate, Date deletionDate, int score, String body, int ownerUserId, int approveUserId, int lastEditorUserId, Date lastEditDate, int commentCount) {
        this.id = id;
        this.questionId = questionId;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
        this.score = score;
        this.body = body;
        this.ownerUserId = ownerUserId;
        this.approveUserId = approveUserId;
        this.lastEditorUserId = lastEditorUserId;
        this.lastEditDate = lastEditDate;
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(int ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public int getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(int approveUserId) {
        this.approveUserId = approveUserId;
    }

    public int getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorUserId(int lastEditorUserId) {
        this.lastEditorUserId = lastEditorUserId;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", creationDate=" + creationDate +
                ", deletionDate=" + deletionDate +
                ", score=" + score +
                ", body='" + body + '\'' +
                ", ownerUserId=" + ownerUserId +
                ", approveUserId=" + approveUserId +
                ", lastEditorUserId=" + lastEditorUserId +
                ", lastEditDate=" + lastEditDate +
                ", commentCount=" + commentCount +
                '}';
    }
}
