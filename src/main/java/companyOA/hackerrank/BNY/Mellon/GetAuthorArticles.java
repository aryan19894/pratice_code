package companyOA.hackerrank.BNY.Mellon;

import java.util.List;

public class GetAuthorArticles {

    public static List<String> getArticleTitles(String author) {
        return null;
//		String response;
//        int startPage = 1;
//        int totalPages = Integer.MAX_VALUE;
//        List<String> titles = new ArrayList<>();
//        while (startPage <= totalPages) {
//            try {
//                URL obj = new URL(
//                        "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" + startPage);
//                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//                con.setRequestMethod("GET");
//                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                while ((response = in.readLine()) != null) {
//                    JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
//                    totalPages = convertedObject.get("total_pages").getAsInt();
//                    JsonArray data = convertedObject.getAsJsonArray("data");
//                    for (int i = 0; i < data.size(); i++) {
//                        JsonObject result = data.get(i).getAsJsonObject();
//                        String title = !result.get("title").isJsonNull() ? result.get("title").getAsString() : null;
//                        String storyTitle = !result.get("story_title").isJsonNull() ? result.get("story_title").getAsString() : null;
//                        if(title != null ) {
//                            titles.add(title);
//                        } else if (title == null && storyTitle != null) {
//                            titles.add(storyTitle);
//                        }
//                    }
//                }
//                in.close();
//                startPage++;
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        }
//        return titles;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
