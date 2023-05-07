package com.erp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    // we dont want to give access
    //static b/c it will be called in static methods
    static {
        try {


            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file);
            file.close();
        }catch (IOException e){

            System.out.println("FILE NOT FOUND WITH THE GIVEN PATH!!!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}


