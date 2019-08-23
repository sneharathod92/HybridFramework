package com.clc.hybrid.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public String getApplicationUrl() {
		String url = prop.getProperty("baseurl");
		return url;

	}

	public String getUserName() {
		String name = prop.getProperty("username");
		return name;

	}

	public String getUserPwd() {
		String pwd = prop.getProperty("password");
		return pwd;

	}

	public String getChromPath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;

	}
	
	public String getfirFoxPath() {
		String firepath = prop.getProperty("firefoxpath");
		return firepath;
	}
	
	public String getiepath() {
		String interpath = prop.getProperty("iepath");
		return interpath;
		
	}
}
