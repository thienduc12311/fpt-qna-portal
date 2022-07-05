package swp391.fptqna.dto;

import java.util.ArrayList;

public class ExtendedQuestionDTO extends QuestionDTO {
    private ArrayList<TagDTO> tags = new ArrayList<TagDTO>();

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

    public ArrayList<TagDTO> getTags() {
        return tags;
    }

    public void setTags(ArrayList<TagDTO> tags) {
        this.tags = tags;
    }
}
