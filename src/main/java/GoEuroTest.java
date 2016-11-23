import com.opencsv.CSVWriter;
import network.HTTPQuery;
import utils.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoEuroTest {

    public static void main(String[] args){

        if (!validateInput(args[0])) return;

        try {
            HTTPQuery query = new HTTPQuery();
            String response = query.sendingGetRequest(args[0]);

            JSONParser parser = new JSONParser();
            List<String[]> list = parser.parseJson(response);;

            writeToFile(list, "output.csv");
        } catch (MalformedURLException e){
            System.out.println("Wrong URL address");
        } catch (IOException e){
            System.out.println("Could not connect to the server");
        }
    }

    private static boolean validateInput(String city) {
        if (city == null){
            System.out.println("You need to pass a city-name argument to the program.");
            return false;
        }

        String pattern = "[a-z]+";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(city);

        if (!m.matches()){
            System.out.println("Input can only contain a-z or A-Z characters");
            return false;
        }
        return true;
    }

    private static void writeToFile(List<String[]> list, String fileName) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(fileName), '\t');
            writer.writeAll(list);
            writer.close();
        } catch (IOException e){
            System.out.println("Cannot access file: " + fileName);
        }
    }

}