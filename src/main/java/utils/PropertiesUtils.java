package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static final PropertiesUtils INSTANCE = new PropertiesUtils(); // to jest singleton, musi być statyczna


    // singleton ma prywatny konstruktor
    // statyczna instacja do ktorej mamy dostep lub mamy prywatna i ustawiamy gettery
    private PropertiesUtils (){
        Properties properties = new Properties();
        String propertyFile = "application.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(propertyFile);
        try {
            properties.load(stream);
        } catch (IOException e) {
            System.out.println("There were problems loading property file.");
        }
        System.setProperties(properties);
    }

    public String getPropertyStringValue (String key){ // to co w propertisie po lewej
        Object obj = System.getProperties().get(key); // zawsze bedzie string na koncu, neiwazne czy wpiszemy liczby czy nie
        return (String) obj;
    }
    public int getPropertiesIntValue(String key){
        return Integer.parseInt(getPropertyStringValue(key));
    }
}
