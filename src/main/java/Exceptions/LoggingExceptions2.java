package Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptions2 {
	private static Logger logger = 
			Logger.getLogger("LoggingExceptions2");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}
		
		/**
		 * 七月 07, 2017 4:06:57 下午 Exceptions.LoggingExceptions2 logException
		         严重: java.lang.NullPointerException
	 			at Exceptions.LoggingExceptions2.main(LoggingExceptions2.java:18)

		 */
	}
}
