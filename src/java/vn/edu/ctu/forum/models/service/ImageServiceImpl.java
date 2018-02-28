/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.dao.ImageDAO;
import vn.edu.ctu.forum.models.dao.ImageDAOImpl;
import vn.edu.ctu.forum.models.dao.MemberImageDAO;
import vn.edu.ctu.forum.models.dao.MemberImageDAOImpl;
import vn.edu.ctu.forum.models.pojos.Image;
import vn.edu.ctu.forum.models.pojos.MemberImage;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class ImageServiceImpl implements ImageService {

    private final ImageDAO imageDao;

    public ImageServiceImpl() {
        this.imageDao = new ImageDAOImpl();
    }

    @Override
    public boolean addImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image findById(int id) {
        Image image = null;
        try {
            ResultSet rs = this.imageDao.findById(id);
            while (rs.next()) {
                String imageAlt = rs.getString("image_alt");
                String imageSrc = rs.getString("image_src");
                Date imageDate = rs.getDate("image_date_upload");
                image = new Image(imageAlt, imageSrc, imageDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
//    public static void main(String[] args) {
//        ImageService imgs = new ImageServiceImpl(null);
//        Image image = imgs.findById(1);
//        System.out.println(image.getImageAlt());
//        System.out.println(image.getImageSrc());
//    }

    @Override
    public ConnectionPool getConnectionPool() {
        return this.imageDao.getConnectionPool();
    }

    @Override
    public void releaseConnection() {
        this.imageDao.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.imageDao.refreshConnectionPool();
    }

    @Override
    public Image findByIdMember(int id) {
        MemberImageDAO mi = new MemberImageDAOImpl();
        ResultSet rs = mi.findByMemberId(id);
        Image image;
        MemberImage mio = null;
        try {
            while (rs.next()) {
                Integer idImage = rs.getInt("image_id");
                Integer idMember = rs.getInt("member_id");
                mio = new MemberImage(idImage, idMember);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImageServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(mio !=null){
            image = findById(mio.getImageID());            
        }else{
            image = findById(1);
        }
        return image;
    }
    
//    public static void main(String[] args) {
//        ImageService ig = new ImageServiceImpl(null);
//        Image img = ig.findByIdMember(1);
//        System.out.println(img.getImageAlt());
//    }

    @Override
    public Integer addGetLastId(Image image) {
        return imageDao.getLastID(image);
    }
}
