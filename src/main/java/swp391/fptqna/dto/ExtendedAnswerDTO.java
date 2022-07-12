package swp391.fptqna.dto;

import swp391.fptqna.utils.DateFormatter;

import java.util.ArrayList;
import java.util.Date;

public class ExtendedAnswerDTO extends AnswerDTO {
    private String ownerUserName;
    private String ownerUserAvt;
    private ArrayList<CommentDTO> comments = new ArrayList<CommentDTO>();

    public ExtendedAnswerDTO() {
    }

    public ExtendedAnswerDTO(int id, int questionId, Date creationDate, Date deletionDate, int score, String body, int ownerUserId, int approveUserId, int lastEditorUserId, Date lastEditDate, int commentCount, String ownerUserAvt, String ownerUserName) {
        super(id, questionId, creationDate, deletionDate, score, body, ownerUserId, approveUserId, lastEditorUserId, lastEditDate, commentCount);
        this.ownerUserAvt = ownerUserAvt;
        this.ownerUserName = ownerUserName;
    }

    public String getStringCreationDate() {
        return DateFormatter.convertFromDateToString(this.getCreationDate());
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getOwnerUserAvt() {
        return ownerUserAvt;
    }

    public void setOwnerUserAvt(String ownerUserAvt) {
        this.ownerUserAvt = ownerUserAvt;
    }

    public ArrayList<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentDTO> comments) {
        this.comments = comments;
    }

}