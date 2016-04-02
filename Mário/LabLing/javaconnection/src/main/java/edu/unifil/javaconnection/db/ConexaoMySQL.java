/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unifil.javaconnection.db;

import edu.unifil.javaconnection.misc.ReadJSONConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author mhadaniya
 */
public class ConexaoMySQL {

    public ConexaoMySQL() {
    }
    
    public static Connection getConexao() throws Exception{
        Connection connection = null;        
        
        String driverName = "com.mysql.jdbc.Driver"; 
        Class.forName(driverName);

        ReadJSONConfig readJSONConfig = new ReadJSONConfig();
        String[] config = readJSONConfig.getConfig();
        connection = DriverManager.getConnection(config[2], config[1], config[0]);
        
        return connection;
    }
    
}
