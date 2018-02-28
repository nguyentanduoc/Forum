/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import vn.edu.ctu.forum.models.untils.ConnectionPool;
/**
 *
 * @author NTD
 */
public interface ShareConnectionManager {
    
    //lay bo ket noi
    public ConnectionPool getConnectionPool();
    //kiem tra va tra lai ket noi
    public void releaseConnection();
    //lam moi connection pool
    public void refreshConnectionPool();
}
