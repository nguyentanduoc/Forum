/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NTD
 */
public interface BaseDAO extends ShareConnectionManager{
    
    //phuong thuc them moi su dung PreparedStatement
    public boolean add(PreparedStatement pre);
    //update
    public boolean edit(PreparedStatement pre);
    //delete
    public boolean del(PreparedStatement pre);
    //truy van su dung PreparedStatement
    public ResultSet get(PreparedStatement pre);
    //truy van su dung String
    public ResultSet get(String sql);
    //add get last id
    public Integer addGetLastID(PreparedStatement pre);
}
