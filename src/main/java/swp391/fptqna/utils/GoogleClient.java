package swp391.fptqna.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class GoogleClient {
    private final String PRODUCTION = "production";
    private String googleClientId = "987580920862-pdimkjajbgu8qoj80o3mt0bgsrgf53ti.apps.googleusercontent.com";
     private  String googleClientSecret = "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";
    private String googleRedirectUri = "http://localhost:8080/login-google";
   private String googleLinkGetUserInfo = "https://openidconnect.googleapis.com/v1/userinfo?access_token=";
   private String googleLinkGetToken ="https://oauth2.googleapis.com/token";
    private String googleGrantType = "authorization_code";

    public GoogleClient() {
        String stage = System.getenv("STAGE");
        if (stage == null) {
            stage = "";
        }
        boolean  isProduction = stage.equals(PRODUCTION);
        if (isProduction) {
            this.googleRedirectUri = System.getenv("GOOGLE_REDIRECT_URI");
            this.googleClientSecret = System.getenv("GOOGLE_CLIENT_SECRET");
            this.googleClientId = System.getenv("GOOGLE_CLIENT_ID");
            this.googleRedirectUri = System.getenv("GOOGLE_REDIRECT_URI");
        }

    }
    public String getGoogleLinkGetToken() {
        return googleLinkGetToken;
    }
    public String getGoogleClientId() {
        return googleClientId;
    }

    public String getGoogleClientSecret() {
        return googleClientSecret;
    }

    public String getGoogleRedirectUri() {
        return googleRedirectUri;
    }

    public String getGoogleLinkGetUserInfo() {
        return googleLinkGetUserInfo;
    }

    public String getGoogleGrantType() {
        return googleGrantType;
    }
}
