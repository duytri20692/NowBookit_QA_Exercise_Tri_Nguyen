package com.nowbookit.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFileHelper {
    public static String readPropertiesFile(String pathFile, String propertyKey){
        // Read test data from properties file
        FileReader reader = null;
        try {
            reader = new FileReader(pathFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            System.out.println("Cannot load file!");
        }
        return p.getProperty(propertyKey);
    }
}
