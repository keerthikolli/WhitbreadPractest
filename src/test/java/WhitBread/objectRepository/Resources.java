package WhitBread.objectRepository;




    import io.restassured.RestAssured;

    public class Resources {

        public static String baseURI =  "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com";
        public static String CreateCustomer= "api/hotel/customer ";
        public static String GetCustomer = "api/hotel/customer/{email}";
        public static String DeleteCustomer = "api/hotel/customer/{DeleteEmail}";

    }

