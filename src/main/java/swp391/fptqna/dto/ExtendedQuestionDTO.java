package swp391.fptqna.dto;

import java.util.ArrayList;

public class ExtendedQuestionDTO extends QuestionDTO {
    private ArrayList<TagDTO> tags = new ArrayList<>();
    private ArrayList<CommentDTO> comments = new ArrayList<>();
    private ExtendedAnswerList answerList = new ExtendedAnswerList();
    private ReasonRejectDTO reject = new ReasonRejectDTO();

    public ExtendedQuestionDTO(QuestionDTO question) {
        super();
        this.setId(question.getId());
        this.setCreationDate(question.getCreationDate());
        this.setClosedDate(question.getClosedDate());
        this.setDeletionDate(question.getDeletionDate());
        this.setScore(question.getScore());
        this.setTitle(question.getTitle());
        this.setBody(question.getBody());
        this.setOwnerUserId(question.getOwnerUserId());
        this.setOwnerAvt(question.getOwnerAvt());
        this.setOwnerName(question.getOwnerName());
        this.setApproveUserId(question.getApproveUserId());
        this.setApproveUserAvt(question.getApproveUserAvt());
        this.setApproveUserName(question.getApproveUserName());
        this.setLastEditorUserId(question.getLastEditorUserId());
        this.setLastEditDate(question.getLastEditDate());
        this.setAnswerCount(question.getAnswerCount());
        this.setCommentCount(question.getCommentCount());
    }

    public ReasonRejectDTO getReject() {
        return reject;
    }

    public void setReject(ReasonRejectDTO reject) {
        this.reject = reject;
    }

    public ArrayList<TagDTO> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagDTO> tags) {
        this.tags = tags;
    }

    public ArrayList<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentDTO> comments) {
        this.comments = comments;
    }

    public ExtendedAnswerList getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ExtendedAnswerList answerList) {
        this.answerList = answerList;
    }
}