package com.selenium.nosalty.logger;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;

public class Logger {

    private final org.apache.logging.log4j.Logger logger;

    public Logger(final Class<?> clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public void info(final String message) {
        Reporter.log(message + "\n");
        logger.info(message);
    }

    public void debug(final String message) {
        Reporter.log(message + "\n");
        logger.debug(message);
    }
}
