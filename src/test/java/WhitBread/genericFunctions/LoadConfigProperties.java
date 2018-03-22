package WhitBread.genericFunctions;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigProperties {

    static Properties prop = new Properties();{
        try{
            if(System.getProperty("config.properties") != null){
                prop.load((new FileInputStream(System.getProperty("config.properties"))));
            }
            else{
                InputStream input = getClass().getResourceAsStream("/config.properties");
                prop.load(input);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

}

