import okhttp3.*;
import java.io.IOException;

public class API_example {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/NcmRba2CroVoIwC20pdtjUpkV-VmwCeLW7Tfy3jm6_Tpt_7ArCpKsMALsioBC3MROaJA-uI0_rGFPA/ids?start=0&count=20")
                .addHeader("X-Riot-Token", "RGAPI-803cfc79-dfaf-4a01-a9b8-31540cf26d93")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        System.out.println(response.body().string());
    }
}
