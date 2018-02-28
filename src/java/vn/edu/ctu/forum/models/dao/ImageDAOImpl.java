/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Image;

/**
 *
 * @author NTD
 */
public class ImageDAOImpl extends BaseDAOImpl implements ImageDAO {

    public ImageDAOImpl() {
        super();
    }

    @Override
    public boolean add(Image im) {
        boolean kq;
        try {
            String sql = "INSERT INTO `image`(`image_alt`, `image_src`, `image_date_upload`) VALUES (?,?,now())";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, im.getImageAlt());
            pre.setString(2, im.getImageSrc());
            kq = this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public ResultSet findById(int id) {
        ResultSet kq;
        try {
            String sql = "SELECT `image_id`, `image_alt`, `image_src`, `image_date_upload` FROM `image` WHERE `image_id` = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public Integer getLastID(Image img) {
        Integer kq;
        try {
            String sql = "INSERT INTO `image`(`image_alt`, `image_src`, `image_date_upload`) VALUES (?,?,now())";
            PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, img.getImageAlt());
            pre.setString(2, img.getImageSrc());
            kq = this.addGetLastID(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = 0;
        }
        releaseConnection();        
        return kq;
    }

//    public static void main(String[] args) {
//
//        ImageDAO image = new ImageDAOImpl(null);
//        Image img = new Image("test", "test");
//        System.out.println(image.getLastID(img));
//
//    }
//    public static void main(String[] args) {
//        try {
//            ImageDAO imagdao = new ImageDAOImpl(null);
//            ResultSet rs = imagdao.findById(2);
//            while(rs.next()){
//                System.out.println(rs.getString(2));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ImageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
