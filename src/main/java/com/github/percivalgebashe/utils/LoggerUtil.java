package com.github.percivalgebashe.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    private static Logger logger;

    public static void sendInfo(String className, String method, String msg){
        logger = LogManager.getLogger(className);
        logger.info("Class: " + className +
                "\nTest Method: " + method +
                "\nMessage: " + msg);
    }

    public static void sendError(String className, String method, String msg){
        logger = LogManager.getLogger(className);
        logger.error("Class: " + className +
                "\nTest Method: " + method +
                "\nMessage: " + msg);
    }
}
