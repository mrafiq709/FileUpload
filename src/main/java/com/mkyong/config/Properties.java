package com.mkyong.config;

public class Properties {

	public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/file_upload";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";

    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    public static final String HIBERNATE_SHOW_SQL = "true";
    public static final String HBM2DDL_AUTO = "update";
    public static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "com.mkyong.entity";
    
    public static final String SMTP_HOST = "smtp.gmail.com";
    public static final String SMTP_PORT = "465";
    public static final String SMTP_CLASS = "javax.net.ssl.SSLSocketFactory";
    public static final String SMTP_AUTH = "true";
    
    public static final String TEMP_PATH = "E:/temp/";
}
