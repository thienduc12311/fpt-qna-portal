package swp391.fptqna.utils;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
public class GoogleUtil {
    public static String getToken(final String code) throws ClientProtocolException, IOException {
        GoogleClient googleClient = new GoogleClient();
        String response = Request.Post(googleClient.getGoogleLinkGetToken()).bodyForm(Form.form().add("client_id", googleClient.getGoogleClientId())
                        .add("client_secret", googleClient.getGoogleClientSecret())
                        .add("redirect_uri", googleClient.getGoogleRedirectUri())
                        .add("code", code)
                        .add("grant_type", googleClient.getGoogleGrantType()).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        GoogleClient googleClient = new GoogleClient();
        String link = googleClient.getGoogleLinkGetUserInfo() + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        return googlePojo;
    }
}
