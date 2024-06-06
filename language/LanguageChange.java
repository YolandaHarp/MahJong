package language;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LanguageChange {
    private int languageCode=0;
    private final int LANGUAGE_TOTAL = 5;
    private static LanguageChange language=new LanguageChange();
    private LanguageChange(){}
    public static LanguageChange getLanguage(){
        return language;
    }
    public void languageUp() {
        languageCode++;
        if(languageCode== LANGUAGE_TOTAL){
            languageCode=0;
        }
    }
    public void languageDown() {
        languageCode--;
        if(languageCode<0){
            languageCode= LANGUAGE_TOTAL -1;
        }
    }
    public String getString(String key){
        // Read text from .properties files

        Properties properties = new Properties();
        try {
            properties.load(getClass().getResource("language_" + languageCode + ".properties").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(properties.getProperty(key).toString().getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
