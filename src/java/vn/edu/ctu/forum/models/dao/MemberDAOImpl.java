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
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class MemberDAOImpl extends BaseDAOImpl implements MemberDAO {

    public MemberDAOImpl() {
        super();
    }

    @Override
    public boolean addMember(Member member) {
        boolean kq;
        try {
            String sql = "INSERT INTO `member`("
                    + "`member_id`, `member_name`, "
                    + "`member_email`, `member_pass`, "
                    + "`member_date_register`) VALUES "
                    + "(null,?,?,?,now())";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, member.getMemberName());
            pre.setString(2, member.getMemberEmail());
            pre.setString(3, member.getMemberPass());
            kq = this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean editMember(Member member) {
        boolean kq;
        try {
            String sql = "UPDATE `member` SET `member_name`=?,`member_sex`=?,`member_birthday`=?,`member_introduce`=? WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, member.getMemberName());
            pre.setString(2, member.getMemberSex());
            pre.setString(3, member.getStrDate());
            pre.setString(4, member.getMemberIntroduce());
            pre.setInt(5, member.getMemberId());
            kq = this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

//    public static void main(String[] args) {
//        MemberDAO m = new MemberDAOImpl(null);
//        Member mo = new Member(1, "Nguyễn Tấn Được","Nam","1996-06-01", "Admin 1");
//        System.out.println(m.editMember(mo));
//    }
    @Override
    public boolean delMember(int id) {
        boolean kq;
        try {
            String sql = "DELETE FROM `member` WHERE 0";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            kq = this.delMember(id);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public ResultSet findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public ResultSet findByEmail(String email) {
        ResultSet kq;
        try {
            String sql = "SELECT `member_id`, `member_name`, `member_email`, `member_pass`, "
                    + "`member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, "
                    + "`member_introduce`, `member_accept` FROM `member`"
                    + " WHERE `member_email`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, email);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

//    public static void main(String[] args) throws SQLException {
//        MemberDAO m = new MemberDAOImpl(null);
//        
//        ResultSet rs = m.findById(1);
//        
//        if (rs!=null) {
//            while (rs.next()) {
//                System.out.println(rs.getString("member_email") + "..");
//                System.out.println("none1");
//            }
//            System.out.println("if");
//        } else {
//            System.out.println("none");
//        }
//    }
    @Override
    public ResultSet findByAccept() {
        ResultSet kq;
        String sql = "SELECT `member_id`, `member_name`,"
                + " `member_email`, `member_pass`, `member_sex`,"
                + " `member_birthday`, `member_isAdmin`,"
                + " `member_date_register`, `member_introduce`,"
                + " `member_accept` FROM `member` WHERE `member_accept` = 0";
        kq = this.get(sql);
        releaseConnection();
        return kq;
    }

    @Override
    public boolean editAcceptMember(int id) {
        boolean kq;
        try {
            Member member = new Member(id);
            String sql = "UPDATE `member` SET `member_accept`=1 WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.edit(pre);

        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }
//    public static void main(String[] args) {
//        MemberDAO m = new MemberDAOImpl(null);
//        
//        if(m.editAcceptMember(3)){
//                        
//            System.out.println("OK");
//        }else
//        System.out.println("eooo");
//    }

    @Override
    public ResultSet findById(int id) {
        ResultSet kq;
        try {
            String sql = "SELECT `member_id`, `member_name`, `member_email`, `member_pass`, "
                    + "`member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, "
                    + "`member_introduce`, `member_accept` FROM `member`"
                    + " WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq=  this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public boolean changePass(int id, String pass) {
        boolean kq;
        try {
            String sql = "UPDATE `member` SET `member_pass`=? WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, pass);
            pre.setInt(2, id);
            kq=  this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean delAcceptMember(int id) {
        boolean kq;
        try {
            String sql = "UPDATE `member` SET `member_accept`=2 WHERE `member_id`=?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }
}
