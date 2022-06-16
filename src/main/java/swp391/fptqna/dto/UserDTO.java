package swp391.fptqna.dto;

public class UserDTO {
  private String email;
  private String name;
  private String password;
  private String avtUrl;

    public String getAvtUrl() {
        return avtUrl;
    }

    public void setAvtUrl(String avtUrl) {
        this.avtUrl = avtUrl;
    }

    private int role;
  private int score;
  private boolean state;
  private String bio;



    public UserDTO(String email, String name, String password, String avtUrl, int score, int role, boolean state, String bio) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.avtUrl = avtUrl;
        this.score = score;
        this.role = role;
        this.state = state;
        this.bio = bio;

    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
