/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.dao.SubjectDAO;
import vn.edu.ctu.forum.models.dao.SubjectDAOImpl;
import vn.edu.ctu.forum.models.pojos.Image;


/**
 *
 * @author PC
 */
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAO subjectDAO;

    public SubjectServiceImpl() {
        this.subjectDAO = new SubjectDAOImpl();
    }
     @Override
    public ConnectionPool getConnectionPool() {
         return this.subjectDAO.getConnectionPool();
    }

    @Override
    public void releaseConnection() {
        this.subjectDAO.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.subjectDAO.refreshConnectionPool();
    }

    @Override
    public boolean addSubject(Subject sj, Image img) {
        if (findById(sj.getSubjectId()) == null) {
           ImageService imageService = new ImageServiceImpl();
           int imageId = imageService.addGetLastId(img); 
            
           if (imageId>0) {
                Subject sb = new Subject(sj.getSubjectId(), sj.getSubjectName(), imageId);
                return this.subjectDAO.addSubject(sb);
            } else {
                return false;
            }
        }
        return false;
    }
//    public static void main(String[] args) {
//        SubjectService sbs = new SubjectServiceImpl(null);
//        Image img = new Image("test2", "test2");        
//        Subject sj = new Subject("cntt2", "cong nghe thong tin2");
//        if(sbs.addSubject(sj, img)) System.out.println("oke");
//        else System.out.println("out");
//    }
    @Override
    public boolean edtSubject(Subject sj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delSubject(Subject sj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subject> findAll() {
        ResultSet rs = this.subjectDAO.findAll();
        List<Subject> listSubject = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    Subject sb = new Subject(rs.getString("subject_id"), rs.getString("subject_name"), rs.getInt("image_id"));
                    listSubject.add(sb);
                } catch (SQLException ex) {
                    Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSubject;
    }

    @Override
    public List<Subject> find(int start, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) {
//        SubjectService sbs = new SubjectServiceImpl(null);
//         if(sbs.findById("test")!=null){
//            System.out.println("oke");
//            System.out.println(sbs.findById("test").getSubjectName());
//        }
//        else{
//            System.out.println("eo");
//        }
//    }
    @Override
    public Subject findById(String id) {
        Subject b = null;
        try {
            ResultSet rs = subjectDAO.findByID(id);            
            if (rs.next()) {
                String subject_id = rs.getString("subject_id");
                String subject_name = rs.getString("subject_name");
                ImageService imageService = new ImageServiceImpl();
                Image image = imageService.findById(rs.getInt("image_id"));
                b = new Subject(subject_id, subject_name, image);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }   
}
