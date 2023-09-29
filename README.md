# CSC207 Project Idea and API Exploration

## Project Idea
League of Legends is a MOBA video game developed by Riot games, and it has become one of the most popular video games 
in the world. It not only provides the players a perfect platform for social, and also gives the players a sense of 
accomplishment when the players reach higher ranks. Hence, the players often need to check their performance on 
recent matches. They might be curious about specific data which reflects their performance, for example, damage dealt,
gold earned, damage taken etc. They might be also curious about the stats of the opponents and the teammates. 

League of Legends stats lookup applications such as u.gg and op.gg are very convenient tools that allow you to check the 
stats on your mobile phone. However, these applications do not provide, or provide limited information about how your 
performance changes overtime. 

This inspires us to build our own version of League of Legends stats lookup application. We will build an application 
such that:
- Allows users to check any player's stats (recent matches, rank, average KDA, etc.) by the player's ID. 
- Allow users to check the stats for a specific match, such as the damage dealt, damage taken, gold earned, wards placed, etc. for every player involved in this match.
- Allows users to check any player's change in performance over time. The change in performance includes for example:
  - Change in the common stats
  - Change in rank
  - Change in gaming frequency
- Allows users to check their play styles (prefers combat or income). 
- Has a clean UI which allow the user to access different information easily and provides the user a nice visualization
of the stats.

## API Exploration
- For this project, we are thinking of using the Riot Games API. It allows us to access for example, information about 
a given match or player. Here is the link to the documentation of this API:
https://developer.riotgames.com/apis#account-v1
- Here we have some screenshot of using tools to try out the API calls.
  <img width="1499" alt="截屏2023-09-28 下午9 31 17" src="https://github.com/kongbaiiiii/207project/assets/71997418/a1f7c5d4-7e42-4bf8-9cd3-56dafdfe34d2">
  This API call gives access to all data for a match, including kills, assists, deaths etc.
  
  <img width="1177" alt="截屏2023-09-28 下午9 46 58" src="https://github.com/kongbaiiiii/207project/assets/71997418/8e9bfcd4-d7e3-43c3-be0d-4828d197456e">
  This API call gives basic information about a user account, including all sorts of ids, username, user level etc. 
  <img width="1123" alt="截屏2023-09-28 下午9 53 22" src="https://github.com/kongbaiiiii/207project/assets/71997418/b2d3b68b-eca8-466e-9988-c1e1721bb6ed">
  This API call gives information about a user's familiarity with each champion and the last time this champion was played

- Here is our API call demo in Java:
```java
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
```
This API call will get a list of 'match ids' by 'puuid'. Here is the output:
```java
Response{protocol=http/1.1, code=200, message=OK, url=https://americas.api.riotgames.com/lol/match/v5/matches/by-puuid/NcmRba2CroVoIwC20pdtjUpkV-VmwCeLW7Tfy3jm6_Tpt_7ArCpKsMALsioBC3MROaJA-uI0_rGFPA/ids?start=0&count=20}
["NA1_4785227104","NA1_4784953825","NA1_4784442959","NA1_4784414771","NA1_4784357381","NA1_4784323721","NA1_4783528029","NA1_4781341135","NA1_4781151319","NA1_4781119049","NA1_4781092359","NA1_4781074209","NA1_4781056063","NA1_4780549194","NA1_4780531875","NA1_4780511262","NA1_4780304778","NA1_4780283900","NA1_4779486142","NA1_4779466080"]
```

## Technical Problems (If Any)
- A list of any technical problems blocking our progress.
