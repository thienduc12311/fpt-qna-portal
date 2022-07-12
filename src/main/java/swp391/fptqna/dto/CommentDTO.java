package swp391.fptqna.dto;

import swp391.fptqna.utils.DateFormatter;

import java.util.Date;

public class CommentDTO {
    private int id;
    private int parentId;
    private String content;
    private Date creationDate;
    private int userId;
    private String userName;
    private String userAvt;

    public CommentDTO(int id, int parentId, String content, Date creationDate, int userId, String userName, String userAvt) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
        this.creationDate = creationDate;
        this.userId = userId;
        this.userName = userName;
        this.userAvt = userAvt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvt() {
        return userAvt;
    }

    public void setUserAvt(String userAvt) {
        this.userAvt = userAvt;
    }

    public String getStringCreationDate() {
        return DateFormatter.convertFromDateToString(creationDate);
    }

}