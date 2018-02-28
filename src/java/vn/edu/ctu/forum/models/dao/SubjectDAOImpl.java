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
import vn.edu.ctu.forum.models.pojos.Subject;

/**
 *
 * @author PC
 */
public class SubjectDAOImpl extends BaseDAOImpl implements SubjectDAO {

    public SubjectDAOImpl() {
        super();
    }

    @Override
    public boolean addSubject(Subject sb) {
        boolean kq;
        try {
            String sql = "INSERT INTO `subject`(`subject_id`, `image_id`, `subject_name`) VALUES (?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, sb.getSubjectId());
            pre.setInt(2, sb.getImageId());
            pre.setString(3, sb.getSubjectName());
            kq = this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }
//    public static void main(String[] args) {
//        SubjectDAO sjDAO = new SubjectDAOImpl();
//        Subject sb = new Subject("test","test", 26);
//        if(sjDAO.addSubject(sb)){
//            System.out.println("oke");
//        }else System.out.println("out");
//    }

    @Override
    public boolean editSubject(Subject sb) {
        boolean kq;
        try {
            String sql = "UPDATE `subject` SET `subject_name`=? WHERE `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, sb.getSubjectId());
            pre.setString(2, sb.getSubjectName());
            kq = this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean delSubject(String id) {
        boolean kq;
        try {
            String sql = "DELETE FROM `subject` WHERE `subject_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            kq = this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public ResultSet findAll() {
        ResultSet kq;

        String sql = "SELECT * FROM `subject`";
        kq = this.get(sql);
        releaseConnection();
        return kq;
    }

//    public static void main(String[] args) throws SQLException {
//        SubjectDAO m = new SubjectDAOImpl();
//
//        ResultSet rs = m.findAll();
//
//        if (rs != null) {
//            while (rs.next()) {                
//                System.out.println(rs.getString("subject_id"));
//            }
// 
//            
//        } else {
//            System.out.println("none");
//        }
//    }
    @Override
    public ResultSet findByID(String id) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM `subject` WHERE `subject_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, id);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }
}
