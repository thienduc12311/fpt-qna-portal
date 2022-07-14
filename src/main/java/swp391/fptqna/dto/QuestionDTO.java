package swp391.fptqna.dto;

import swp391.fptqna.utils.DateFormatter;

import java.util.Date;

public class QuestionDTO {
    private int id;
    private Date creationDate;
    private Date closedDate;
    private Date deletionDate;
    private int score;
    private String title;
    private String body;
    private int ownerUserId;
    private String ownerAvt;

    public String getOwnerAvt() {
        return ownerAvt;
    }

    public void setOwnerAvt(String ownerAvt) {
        this.ownerAvt = ownerAvt;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }

    public String getApproveUserAvt() {
        return approveUserAvt;
    }

    public void setApproveUserAvt(String approveUserAvt) {
        this.approveUserAvt = approveUserAvt;
    }

    private String ownerName;
    private int approveUserId;
    private String approveUserName;
    private String approveUserAvt;
    private int lastEditorUserId;
    private Date lastEditDate;
    private int answerCount;
    private int commentCount;

    public QuestionDTO() {
    }

    public QuestionDTO(int id, Date creationDate, Date closedDate, Date deletionDate, int score, String title, String body, int ownerUserId, int approveUserId, int lastEditorUserId, Date lastEditDate, int answerCount, int commentCount) {
        this.id = id;
        this.creationDate = creationDate;
        this.closedDate = closedDate;
        this.deletionDate = deletionDate;
        this.score = score;
        this.title = title;
        this.body = body;
        this.ownerUserId = ownerUserId;
        this.approveUserId = approveUserId;
        this.lastEditorUserId = lastEditorUserId;
        this.lastEditDate = lastEditDate;
        this.answerCount = answerCount;
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
    public String getStringCreationDate (){
        return DateFormatter.convertFromDateToString(creationDate);
    }
    public String getStringDeletionDate(){
        return DateFormatter.convertFromDateToString(deletionDate);
    }
    public  String getStringClosedDate(){
        return DateFormatter.convertFromDateToString(closedDate);
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", closedDate=" + closedDate +
                ", deletionDate=" + deletionDate +
                ", score=" + score +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", ownerUserId=" + ownerUserId +
                ", approveUserId=" + approveUserId +
                ", lastEditorUserId=" + lastEditorUserId +
                ", lastEditDate=" + lastEditDate +
                ", answerCount=" + answerCount +
                ", commentCount=" + commentCount +
                '}';
    }
}