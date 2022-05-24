package swp391.fptqna.utils;

public class GoogleClient {
    public static String GOOGLE_CLIENT_ID = "439318717683-v1og8jquc6kn82nua7sun6cbvkt2oprb.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://oauth2.googleapis.com/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://openidconnect.googleapis.com/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
    public static String SCOPE = "openid%20email";
}
