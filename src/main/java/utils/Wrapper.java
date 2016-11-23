package utils;

/**
 * Created by mikhailsoparin on 22/11/16.
 */
public class Wrapper {

    private Integer id;
    private String name;
    private String type;

    private Double lat;
    private Double lng;

    Wrapper(Integer id, String name, String type, Double lat, Double lng){
        this.id = id;
        this.name = name;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
    }


    public String[] serialize(){
        String[] result = new String[5];

        result[0] = String.valueOf(id);
        result[1] = name;
        result[2] = type;
        result[3] = String.valueOf(lat);
        result[4] = String.valueOf(lng);

        return result;
    }
}
