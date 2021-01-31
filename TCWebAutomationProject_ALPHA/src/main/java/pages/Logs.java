package pages;

import org.apache.log4j.Logger;


public class Logs {


    private static Logger logs;

    public static void initLogger(String className)  {

        logs = Logger.getLogger(className); // logger object


    }

    public static void info(String message){

        logs.info(message);
    }
    public static void error(String message){

        logs.error(message);
    }
}
