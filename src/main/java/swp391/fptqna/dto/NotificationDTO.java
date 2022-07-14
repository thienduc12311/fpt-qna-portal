package swp391.fptqna.dto;

import java.util.Date;

public class NotificationDTO {
    private int Id;
    private int notificationTypeId;
    private Date creationDate;
    private String body;
    private int ownerUserId;
    private boolean state;

    public NotificationDTO(int id, int notificationId, Date creationDate, String body, int ownerUserId, boolean state) {
        Id = id;
        this.notificationTypeId = notificationId;
        this.creationDate = creationDate;
        this.body = body;
        this.ownerUserId = ownerUserId;
        this.state = state;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(int notificationId) {
        this.notificationTypeId = notificationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "Id=" + Id +
                ", notificationId=" + notificationTypeId +
                ", creationDate=" + creationDate +
                ", body='" + body + '\'' +
                ", ownerUserId=" + ownerUserId +
                ", state=" + state +
                '}';
    }
}
