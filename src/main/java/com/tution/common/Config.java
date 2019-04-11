package com.tution.common;


import java.util.HashSet;
import java.util.Set;

public class Config {

	public static String HOST = "localhost:8080";
	public static String DOMAIN = "localhost:8080/tution-bureau";
	public static String SYSTEM_HOST = "NA";
	public static String PROCESS_NAME = "NA";
	public static String DB_NAME = "tution-bureau";
	public static int cph = 500;
	public static boolean replication = true;
	public static int port = 27017;
	public static boolean dev = true;
	public static Set<String> MONGOHOST = new HashSet<String>();
	


	public static String PROTOCOL = "https";
	public static String version = "1";
	
}

