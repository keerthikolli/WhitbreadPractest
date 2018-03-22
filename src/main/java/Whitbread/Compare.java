package Whitbread;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class Compare {
    public static void main(String[] args) throws IOException, ParseException {


        JSONObject ranTest = testread();

    }

    public static JSONObject testread() throws ParseException, IOException {


        String Expectedpath = "C:\\wbTest\\src\\test\\java\\WhitBread\\json\\CreateExpectedResult.json";

        JSONParser parser = new JSONParser();

        JSONObject fileReader = (JSONObject) parser.parse(new FileReader(Expectedpath));


        System.out.println(fileReader);
/*
        JSONParser parser = new JSONParser();
        JSONObject jsonResponse = (JSONObject) parser.parse(fileReader);
*/
        return fileReader; //jsonResponse;
    }
}