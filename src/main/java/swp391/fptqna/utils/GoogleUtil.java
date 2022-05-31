package swp391.fptqna.utils;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
public class GoogleUtil {
    public static String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GoogleClient.GOOGLE_LINK_GET_TOKEN).bodyForm(Form.form().add("client_id", GoogleClient.GOOGLE_CLIENT_ID)
                        .add("client_secret", GoogleClient.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GoogleClient.GOOGLE_REDIRECT_URI)
                        .add("code", code)
                        .add("grant_type", GoogleClient.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GoogleClient.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        return googlePojo;
    }
}
