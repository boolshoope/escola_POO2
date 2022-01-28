/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessObject;

import Model.ValueObject.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author isacl
 */
public class BD {
    
    private String host,bd,user,password,porta;

    public BD() {
        this.host="localhost";//ou 127.0.0.1 
        this.bd="escola";
        this.password="";
        this.user="root";
        this.porta="3306";
    }
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        BD con = new BD();
        return DriverManager.getConnection("jdbc:mysql://"+con.host+"/"+con.bd,con.user,con.password);
    }

    public String getHost() {
        return host;
    }

    public String getBd() {
        return bd;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getPorta() {
        return porta;
    }
}
