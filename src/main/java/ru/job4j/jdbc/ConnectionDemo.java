package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Properties prop = new Properties();
        Class.forName("org.postgresql.Driver");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("app.properties")) {
            prop.load(is);
            String url = prop.getProperty("jdbc.url");
            String login = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");
            try (Connection connection = DriverManager.getConnection(url, login, password)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        }
    }
}