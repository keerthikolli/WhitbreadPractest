package WhitBread.genericFunctions;


import WhitBread.objectRepository.Resources;
import io.restassured.RestAssured;

public class Reuse {
    public static void baseuri(){
        RestAssured.baseURI = Resources.baseURI;
    }


}
