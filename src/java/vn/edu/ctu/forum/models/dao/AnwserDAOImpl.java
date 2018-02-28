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
import vn.edu.ctu.forum.models.pojos.Answer;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author NTD
 */
public class AnwserDAOImpl extends BaseDAOImpl implements AnwserDAO {

    public AnwserDAOImpl() {
        super();
    }

    @Override
    public boolean addAnwer(Answer anwser) {
        boolean kq;
        try {
            String sql = "INSERT INTO `anwser`(`anwser_id`, `question_id`, `member_id`, `anwser_content`, `anwser_date`) "
                    + "VALUES (null,?,?,?,now())";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, anwser.getQuestionId());
            pre.setInt(2, anwser.getMemberId());
            pre.setString(3, anwser.getAnwserContent());
            kq = this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(AnwserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }
//    public static void main(String[] args) {
//        AnwserDAO anwserDAO = new AnwserDAOImpl(null);
//        if(anwserDAO.addAnwer(new Answer(2, "test"))) System.out.println("ok");
//        else System.out.println("faild");
//    }

    @Override
    public ResultSet findByIdQuestion(int subjectId) {
        ResultSet kq;
        try {
            String sql = "SELECT `anwser_id`, `question_id`, `member_id`, `anwser_content`, `anwser_date` FROM"
                    + " `anwser` WHERE `question_id` = ? ORDER BY `anwser_date`";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, subjectId);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(AnwserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }
//    public static void main(String[] args) {
//        try {
//            AnwserDAO anwserDAO = new AnwserDAOImpl(null);
//            ResultSet rs = anwserDAO.findByIdQuestion(2);
//            while(rs.next()){
//                System.out.println(rs.getString("anwser_content"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AnwserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
