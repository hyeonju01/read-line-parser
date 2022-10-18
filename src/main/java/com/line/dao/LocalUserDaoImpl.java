package com.line.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LocalUserDaoImpl extends UserDaoAbstract {

    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c = DriverManager.getConnection("address",
                "root", "password");
        return c;
    }
}