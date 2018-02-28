/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.dao.MemberDAO;
import vn.edu.ctu.forum.models.dao.MemberDAOImpl;
import vn.edu.ctu.forum.models.dao.MemberImageDAO;
import vn.edu.ctu.forum.models.dao.MemberImageDAOImpl;
import vn.edu.ctu.forum.models.pojos.Image;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.untils.HashMD5;

/**
 *
 * @author NTD
 */
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    public MemberServiceImpl() {
        this.memberDAO = new MemberDAOImpl();
    }

    @Override
    public boolean addMember(Member m) {
        if (findByEmail(m.getMemberEmail()) == null) {
            return memberDAO.addMember(m);
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        MemberService mb = new MemberServiceImpl(null);
//        Member m = new Member("admin2", "admin2@gmail.com", "admin2");
//        if (mb.addMember(m)) {
//            System.out.println("oke");
//        } else {
//            System.out.println("fail");
//        }
//    }
    @Override
    public boolean editMember(Member member) {
        return memberDAO.editMember(member);
    }

    @Override
    public boolean delMember() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> findAcceptMember() {
       ResultSet rs = this.memberDAO.findByAccept();
        List<Member> list = new ArrayList<>();
        try {            
            while (rs.next()) {
                try {
                    
                    Member mb = new Member(rs.getInt("member_id"), 
                            rs.getString("member_name"),rs.getString("member_email"),
                            rs.getString("member_pass"),rs.getString("member_sex"),
                            rs.getDate("member_birthday"),rs.getBoolean("member_isAdmin"),
                            rs.getDate("member_date_register"),rs.getString("member_introduce"),
                            rs.getBoolean("member_accept"));
                    list.add(mb);
                } catch (SQLException ex) {
                    Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    @Override
    public List<Member> find(int start, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Member findByEmail(String email) {
        try {
            ResultSet rs = memberDAO.findByEmail(email);
            Member m = null;
            if (rs.next()) {
                Integer memberId = rs.getInt("member_id");
                String memberName = rs.getString("member_name");
                String memberEmail = rs.getString("member_email");
                String memberPass = rs.getString("member_pass");
                String memberSex = rs.getString("member_sex");
                Date memberBirthday = rs.getDate("member_birthday");
                boolean memberIsAdmin = rs.getBoolean("member_isAdmin");
                Date memberDateRegister = rs.getDate("member_date_register");
                String memberIntroduce = rs.getString("member_introduce");
                boolean memberAccept = rs.getBoolean("member_accept");
                m = new Member(memberId, memberName, memberEmail, memberPass, memberSex, memberBirthday, memberIsAdmin, memberDateRegister, memberIntroduce, memberAccept);
                return m;
            } else {
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
//    public static void main(String[] args) {
//        MemberService membs = new MemberServiceImpl(null);
//        List<Member> list =membs.findAcceptMember();
//        
//        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i).getMemberName());
//        }
//    }
    

    @Override
    public ConnectionPool getConnectionPool() {
        return this.memberDAO.getConnectionPool();
    }

    @Override
    public void releaseConnection() {
        this.memberDAO.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.memberDAO.refreshConnectionPool();
    }

    @Override
    public boolean editAcceptMember(int id) {
        boolean rs = memberDAO.editAcceptMember(id);
        Member m = new Member(id);
        return rs;
       }
//    public static void main(String[] args) {
//        MemberService mbsv = new MemberServiceImpl(null);
//        if(mbsv.editAcceptMember(3)){
//         System.out.println("oke");
//        }
//        else{
//           System.out.println("eo");
//        }
//    }
    @Override
    public Member login(String email, String pass) {
        Member m = findByEmail(email);
        if (m != null) {
            if (m.getMemberPass().equals(HashMD5.md5(pass))) {
                return m;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
//    public static void main(String[] args) {
//        MemberService m = new MemberServiceImpl(null);
//        if(m.findById(1)!=null){
//            System.out.println("oke");
//            System.out.println(m.findById(1).getMemberEmail());
//        }
//        else{
//            System.out.println("eo");
//        }
//    }
        
//    public static void main(String[] args) {
//       SubjectService s = new SubjectServiceImpl(null);
//       
//       if(s.findById("2")!=null){
//           System.out.println("ok");
//           System.out.println(s.findById("2").getSubjectName());
//       }
//       else
//           System.out.println("no");
//    }
    @Override
    public Member findById(int id) {
        try {
            ResultSet rs = memberDAO.findById(id);
            Member m = null;
            if (rs.next()) {
                Integer memberId = rs.getInt("member_id");
                String memberName = rs.getString("member_name");
                String memberEmail = rs.getString("member_email");
                String memberPass = rs.getString("member_pass");
                String memberSex = rs.getString("member_sex");
                Date memberBirthday = rs.getDate("member_birthday");
                boolean memberIsAdmin = rs.getBoolean("member_isAdmin");
                Date memberDateRegister = rs.getDate("member_date_register");
                String memberIntroduce = rs.getString("member_introduce");
                boolean memberAccept = rs.getBoolean("member_accept");
                m = new Member(memberId, memberName, memberEmail, memberPass, memberSex, memberBirthday, memberIsAdmin, memberDateRegister, memberIntroduce, memberAccept);
                return m;
            } else {
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean updateAvatar(int memberId, Image image) {
        ImageService imagesv = new ImageServiceImpl();
        int lastId = imagesv.addGetLastId(image);
        MemberImageDAO imgMember = new MemberImageDAOImpl();
        return imgMember.addImageMember(memberId, lastId);
    }

//    public static void main(String[] args) {
//        MemberService m = new MemberServiceImpl(null);
//        Image img = new Image("test", "test.jpg");
//        System.out.println(m.updateAvatar(2, img));
//    }
    @Override
    public boolean changePass(int memberID, String passCurrent, String passNew) {

        MemberDAO md = new MemberDAOImpl();
        Member mo = findById(memberID);
        if(mo.getMemberPass().equals(HashMD5.md5(passCurrent))){
             return md.changePass(memberID,HashMD5.md5(passNew));           
        }else{
            return false;
        }
    }

    @Override
    public List<Member> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delAcceptMember(int id) {
        boolean rs = memberDAO.delAcceptMember(id);
        Member m = new Member(id);
        return rs;
        }
}
