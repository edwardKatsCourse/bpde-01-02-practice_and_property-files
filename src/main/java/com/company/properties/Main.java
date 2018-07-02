package com.company.properties;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {

        //PROPERTY FILES

        //.properties
        //application.properties
        //java.properties
        //file.properties
        //....


        String propertyFile = Thread
                .currentThread()
                .getContextClassLoader()
                .getResource("application.properties")
                .getPath();


        Properties properties = new Properties();

        properties.load(new FileInputStream(propertyFile));

        System.out.println(properties.getProperty("file.directory"));

        String fileToWrite = String.format("%s%s%s.%s",
                properties.getProperty("file.directory"),
                File.separatorChar,
                properties.getProperty("file.filename"),
                properties.getProperty("file.extension"));


        //unix      -   /usr/bin/
        //windows   -   C:\file

        System.out.println(fileToWrite);
        writeToFile(fileToWrite);

        properties.setProperty("java.application.name", "Properties Files Demo");
        System.out.println(properties.getProperty("java.application.name"));

        properties.remove("java.application.name");
        System.out.println("key.subkey: " + properties.getProperty("key.subkey"));
        properties.remove("key.subkey");
        System.out.println("java.application.name: " + properties.getProperty("java.application.name"));
        System.out.println("key.subkey: " + properties.getProperty("key.subkey"));


    }

    private static void writeToFile(String filename) throws IOException {
        FileUtils.write(new File(filename), "this is my default text", "UTF-8");

    }
}
