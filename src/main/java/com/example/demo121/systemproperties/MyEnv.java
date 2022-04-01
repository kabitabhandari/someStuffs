package com.example.demo121.systemproperties;


import java.util.Map;
import java.util.Properties;

public class MyEnv {
    public static void main(String[] args) {
        String [] s = new String[3];
        s[0]="kabita";
        s[1]="rat";

        printEnvironmentVariables();
        printSystemProperties();
        printCommandLineArgument(s);
    }

    private static void printCommandLineArgument(String[] args) {
        System.out.println("CommandLineArguments");
        System.out.println("***********************************************************************");

        for(String i : args){
            System.out.println(i);
        }
        System.out.println("***********************************************************************");

    }

    private static void printSystemProperties() {
        System.out.println("SystemProperties");
        System.out.println("***********************************************************************");

        System.setProperty("AAAA" , "value");
        System.out.println(System.getProperty("AAA"));


       Properties properties =  System.getProperties();
        properties.forEach((k,v)-> System.out.println(k + "  " +v));;
        System.out.println("***********************************************************************");


    }

    private static void printEnvironmentVariables() {
        System.out.println("EnvironmentVariables");
        System.out.println("***********************************************************************");
       Map<String,String> simpleMap = System.getenv();
        simpleMap.forEach((key, value)-> System.out.println(key + "   " + value) );
        System.out.println("***********************************************************************");

    }
}
