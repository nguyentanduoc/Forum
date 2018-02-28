/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class MemberImageDAOImpl extends BaseDAOImpl implements MemberImageDAO {

    public MemberImageDAOImpl() {
        super();
    }

    @Override
    public ResultSet findByMemberId(Integer memberID) {
        ResultSet kq;
        try {
            String sql = "SELECT `image_id`, `member_id` FROM `member_image` WHERE `member_id` = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, memberID);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }
//    public static void main(String[] args) throws SQLException {
//        MemberImageDAO m = new MemberImageDAOImpl(null);
//        ResultSet rs = m.findByMemberId(1);
//        if(rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//        }
//        else System.out.println("eo");
//    }

    @Override
    public boolean addImageMember(Integer memberID, Integer imageID) {
        boolean kq;
        try {
            String sql = "INSERT INTO `member_image`(`image_id`, `member_id`) VALUES (?,?)";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, imageID);
            pre.setInt(2, memberID);
            kq =  this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }
}
