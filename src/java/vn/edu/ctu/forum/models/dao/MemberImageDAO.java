/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;

/**
 *
 * @author NTD
 */
public interface MemberImageDAO extends BaseDAO{
    
    public ResultSet findByMemberId(Integer memberID);
    public boolean addImageMember(Integer memberID, Integer imageID);
}
