package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikhailsoparin on 23/11/16.
 */
public class JSONParser {

    public List<String[]> parseJson(String jsonString) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonString);
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++){
            JsonObject obj = jsonArray.get(i).getAsJsonObject();

            Integer id = Integer.parseInt(obj.get("_id").toString());
            String name = obj.get("name").toString();
            String type = obj.get("type").toString();
            JsonObject geoPosition = obj.get("geo_position").getAsJsonObject();
            Double lat = geoPosition.get("latitude").getAsDouble();
            Double lng = geoPosition.get("longitude").getAsDouble();

            Wrapper wrapper = new Wrapper(id, name, type, lat, lng);
            list.add(wrapper.serialize());
        }
        return list;
    }

}
