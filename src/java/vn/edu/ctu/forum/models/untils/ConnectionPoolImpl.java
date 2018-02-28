/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NTD
 */
public class ConnectionPoolImpl implements ConnectionPool {

    private String dbName;
    private String dbUser;
    private String dbPass;
    private String url;
    private String driver;
    private Stack<Connection> pool;

    public ConnectionPoolImpl() {
        this.dbName = "forumaandq";
        this.dbUser = "root";
        this.dbPass = "";
        this.pool = new Stack<>();
        this.url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        this.driver = "com.mysql.jdbc.Driver";
        try {
            try {
                Class.forName(this.driver).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionPoolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnectionPoolImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnectionPool() throws SQLException {
        if(pool.empty()){
            return DriverManager.getConnection(this.url,this.dbUser,this.dbPass);
        }else{
            return (Connection)this.pool.pop();
        }
    }

    @Override
    public void releaseConnection(Connection conn) throws SQLException {
        this.pool.push(conn);
    }

    @Override
    public void refreshConnectionPool(){
        while(!pool.empty()){
            try {
                pool.pop().close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPoolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
