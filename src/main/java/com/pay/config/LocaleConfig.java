package com.pay.config;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocaleConfig {
	
	
	public static Properties hibernateProps = new Properties(); 
	public static Properties jdbcProps = new Properties(); 
	public LocaleConfig(){}
	static{
		try {
			
			hibernateProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate-config.properties"));
			jdbcProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(Properties props,String key){
		
		return props.getProperty(key);
	}

    public static void updateProperties(Properties props,String key,String value) {    
            props.setProperty(key, value); 
    } 
}
