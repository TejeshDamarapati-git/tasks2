package com.log4j;
import org.apache.logging.log4j.*;
public class LoggingTest {

	private static Logger demologger=LogManager.getLogger(LoggingTest.class.getName());
	
	public static void main(String[] args) {
		
		
		demologger.info("Success");
		demologger.error("ERROR CAUSED......");
		demologger.debug("Debug it");
		demologger.fatal("This is Fatal");

	}
}
