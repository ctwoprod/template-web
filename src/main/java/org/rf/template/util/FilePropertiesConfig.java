package org.rf.template.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilePropertiesConfig {

	private static String PROPERTIES_FILE_NAME = "/WEB-INF/application.properties";
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			Properties prop = new Properties();
			InputStream input = null;

			try {
				input = new FileInputStream(PROPERTIES_FILE_NAME);

				// load a properties file
				prop.load(input);

				// get the property value
				url = prop.getProperty("jdbc.url");
				username = prop.getProperty("jdbc.username");
				password = prop.getProperty("jdbc.password");

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial File Properties is failed ." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

}
