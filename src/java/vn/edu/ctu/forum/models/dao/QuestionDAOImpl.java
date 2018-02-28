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
import vn.edu.ctu.forum.models.pojos.Question;

/**
 *
 * @author Ew
 */
public class QuestionDAOImpl extends BaseDAOImpl implements QuestionDAO {

    public QuestionDAOImpl() {
        super();
    }

    @Override
    public boolean addQuestion(Question question) {
        boolean kq;
        try {
            String sql = "INSERT INTO `question`("
                    + "`question_id`, "
                    + "`subject_id`, "
                    + "`member_id`, "
                    + "`question_name`, "
                    + "`question_decription`, "
                    + "`question_content`, "
                    + "`question_date`) VALUES (null,?,?,?,?,?,now())";//<====Chua chac dung, Sang dep trai da sua r

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, question.getSubjectId());
            pre.setInt(2, question.getMemberId());
            pre.setString(3, question.getQuestionName());
            pre.setString(4, question.getQuestionDecription());
            pre.setString(5, question.getQuestionContent());

            kq = this.add(pre);
            //Date and accect chua biet lam sao.
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean voteUp(int id, int vote) {
        boolean kq;
        try {
            Question question = new Question(id);
            String sql = "UPDATE `question` SET `vote`= ? WHERE `question_id` = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, vote + 1);
            pre.setInt(2, id);
            kq = this.edit(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean voteDown(int id, int vote) {
        boolean kq;
        try {
            Question question = new Question(id);
            String sql = "UPDATE `question` SET `vote`= ? WHERE `question_id` = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, vote - 1);
            pre.setInt(2, id);
            kq = this.edit(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean editQuetion(Question question) {
        boolean kq;
        try {
            String sql = "UPDATE `question` SET "
                    + "`subject_id`=?,"
                    + "`question_name`=?,"
                    + "`question_decription`=?,"
                    + "`question_content`=?,"
                    + "`question_date`=now(),"
                    + "`question_accept`=0 WHERE "
                    + "`question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, question.getSubjectId());
            pre.setString(2, question.getQuestionName());
            pre.setString(3, question.getQuestionDecription());
            pre.setString(4, question.getQuestionContent());
            pre.setInt(5, question.getQuestionId());

            kq = this.edit(pre);
            //Date and accect chua biet lam sao.
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public boolean delQuetion(int id) {
        boolean kq;
        try {
            String sql = "DELETE FROM `question` "
                    + "WHERE `question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.del(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public ResultSet findAll() {
        ResultSet kq;
        String sql = "SELECT * FROM `question` where `question_accept`=1 ";
        kq = this.get(sql);
        releaseConnection();
        return kq;
    }

    @Override
    public ResultSet findByIdMember(int id) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM"
                    + " `question` WHERE"
                    + " `member_id`=? ORDER BY `vote` DESC,`question_date` DESC";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public ResultSet findByAccect() {
        ResultSet kq;
        String sql = "SELECT `question_id`, `subject_id`,"
                + " `member_id`, `question_name`, `question_decription`,"
                + " `question_content`, `question_date`, `question_accept`"
                + " FROM `question` WHERE `question_accept`=0 ORDER BY `vote` DESC,`question_date` DESC";

        kq = this.get(sql);
        releaseConnection();
        return kq;
    }

    @Override
    public boolean editQuestionAccept(int id) {
        boolean kq;
        try {
            Question question = new Question(id);
            String sql = "UPDATE `question` SET `question_accept`= 1 WHERE `question_id` = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.edit(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public ResultSet findByIdSubject(String id) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM"
                    + " `question` WHERE"
                    + " `subject_id`=? ORDER BY `vote` DESC,`question_date` DESC";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            kq = this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public boolean delAcceptQuestion(int id) {
        boolean kq;
        try {
            String sql = "UPDATE `question` SET `question_accept`=2 WHERE `question_id`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = false;
        }
        refreshConnectionPool();
        return kq;
    }

    @Override
    public ResultSet find(int limit, int start) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM `question` where `question_accept` = 1 ORDER BY `vote` DESC,`question_date` DESC LIMIT ? OFFSET ?";
            PreparedStatement pre = connection.prepareCall(sql);
            pre.setInt(1, limit);
            pre.setInt(2, start);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }
    
    @Override
    public ResultSet findById(int id) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM"
                    + " `question` WHERE"
                    + " `question_id`=? ORDER BY `vote` DESC,`question_date` DESC";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            kq = this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public ResultSet findByIdSubject(String id, int litmit, int start) {
        ResultSet kq;
        try {
            String sql = "SELECT * FROM `question` where `question_accept` = 1 and `subject_id` =? ORDER BY `vote` DESC,`question_date` DESC LIMIT ? OFFSET ?";
            PreparedStatement pre = QuestionDAOImpl.connection.prepareCall(sql);
            pre.setString(1, id);
            pre.setInt(2, litmit);
            pre.setInt(3, start);
            kq = this.get(pre);
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            kq = null;
        }
        releaseConnection();
        return kq;
    }

    @Override
    public ResultSet search(String[] searchs, int litmit, int start) {
        ResultSet kq = null;
        PreparedStatement pre;
        String sql = "SELECT * FROM `question` where `question_accept` = 1";
        for (String search : searchs) {
            sql += " and `question_name` like N'%" + search + "%'";
        }
        sql += " ORDER BY `vote` DESC,`question_date` DESC LIMIT ? OFFSET ?";

        try {
            pre = QuestionDAOImpl.connection.prepareCall(sql);
            pre.setInt(1, litmit);
            pre.setInt(2, start);
            kq = this.get(pre);

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        releaseConnection();
        return kq;
    }
//    public static void main(String[] args) {
//        String[] searchs = "thuc hien truy van".split(" ");
//        QuestionDAO aO= new QuestionDAOImpl();
//        ResultSet rs = aO.search(searchs, 4,0);
//        try {
//            while(rs.next()){
//                System.out.println(rs.getString(4));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(QuestionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
