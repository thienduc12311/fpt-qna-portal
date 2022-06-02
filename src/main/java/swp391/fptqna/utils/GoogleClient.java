package swp391.fptqna.utils;

public class GoogleClient {
    public static String GOOGLE_CLIENT_ID = "987580920862-pdimkjajbgu8qoj80o3mt0bgsrgf53ti.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "https://fpt-qna-portal.herokuapp.com/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://oauth2.googleapis.com/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://openidconnect.googleapis.com/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
    public static String SCOPE = "openid%20email";
}
