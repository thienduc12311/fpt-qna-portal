package swp391.fptqna.dto;

public class NotificationViewDTO {
    private NotificationDTO noti;
    private String content;
    private String href;

    public NotificationViewDTO(NotificationDTO noti, String content) {
        this.noti = noti;
        this.content = content;
    }

    public NotificationViewDTO(String content) {
        this.content = content;
    }

    public NotificationDTO getNoti() {
        return noti;
    }

    public void setNoti(NotificationDTO noti) {
        this.noti = noti;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
