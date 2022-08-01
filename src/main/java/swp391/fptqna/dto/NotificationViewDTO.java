package swp391.fptqna.dto;

public class NotificationViewDTO {
    private int noti;
    private String content;

    public NotificationViewDTO(int noti, String content) {
        this.noti = noti;
        this.content = content;
    }

    public NotificationViewDTO(String content) {
        this.content = content;
    }

    public int getNoti() {
        return noti;
    }

    public void setNoti(int noti) {
        this.noti = noti;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
