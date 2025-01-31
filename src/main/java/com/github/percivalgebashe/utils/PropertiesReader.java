package com.github.percivalgebashe.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    static {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
        }catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }

        try {
            properties.load(fis);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getProperty(String property){
        return properties.getProperty(property);
    }

}
