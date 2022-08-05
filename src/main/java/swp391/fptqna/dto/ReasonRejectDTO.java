package swp391.fptqna.dto;

public class ReasonRejectDTO {
    private int questionId;
    private String reason;

    public ReasonRejectDTO(int questionId, String reason) {
        this.questionId = questionId;
        this.reason = reason;
    }

    public ReasonRejectDTO() {

    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}