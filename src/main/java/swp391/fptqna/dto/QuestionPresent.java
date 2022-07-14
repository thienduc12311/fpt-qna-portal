package swp391.fptqna.dto;

public class QuestionPresent {
    private QuestionDTO question;
    private String ownerImg;
    private String ownerDisplayName;

    public QuestionPresent() {
    }

    public QuestionPresent(QuestionDTO question, String ownerImg, String ownerDisplayName) {
        this.question = question;
        this.ownerImg = ownerImg;
        this.ownerDisplayName = ownerDisplayName;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public String getOwnerImg() {
        return ownerImg;
    }

    public void setOwnerImg(String ownerImg) {
        this.ownerImg = ownerImg;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    @Override
    public String toString() {
        return "QuestionPresent{" +
                "question=" + question +
                ", ownerImg='" + ownerImg + '\'' +
                ", ownerDisplayName='" + ownerDisplayName + '\'' +
                '}';
    }
}
