/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.edu.ctu.forum.models.pojos.Question;
import vn.edu.ctu.forum.models.dao.QuestionDAO;
import vn.edu.ctu.forum.models.dao.QuestionDAOImpl;
import vn.edu.ctu.forum.models.pojos.Member;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.untils.ConnectionPool;

/**
 *
 * @author Administrator
 */
public class QuestionServiceImpl implements QuestionService {

    private SubjectService subjectService;
    private MemberService memberService;
    private final QuestionDAO questionDAO;

    public QuestionServiceImpl() {
        this.questionDAO = new QuestionDAOImpl();
    }

    @Override
    public boolean addQuestion(Question question) {
        return questionDAO.addQuestion(question);
    }

    @Override
    public boolean editQuetion(Question question) {
        return questionDAO.editQuetion(question);
    }

    @Override
    public boolean editQuestionAccept(int id) {
        boolean rs = questionDAO.editQuestionAccept(id);
        Question q = new Question(id);
        return rs;
    }

    @Override
    public boolean voteUp(int id, int vote) {
        boolean rs = questionDAO.voteUp(id, vote);
        return rs;
    }

    @Override
    public boolean voteDown(int id, int vote) {
        boolean rs = questionDAO.voteDown(id, vote);
        return rs;
    }

    @Override
    public boolean delQuetion(int id) {
        boolean rs = questionDAO.delQuetion(id);
        return rs;
    }

    @Override
    public List<Question> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> findByIdMember(int id) {
        ResultSet rs = this.questionDAO.findByIdMember(id);
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl();
                    SubjectService ss = new SubjectServiceImpl();
//                    Subject subject = ss.findById(rs.getString("suject_id"));
                    Member member = mb.findById(rs.getInt("member_id"));
                    Question qt = new Question(rs.getInt("question_id"),
                            member, rs.getString("question_name"), rs.getString("question_decription"),
                            rs.getString("question_content"), rs.getDate("question_date"), rs.getInt("question_accept"));
                    listQuestion.add(qt);
                } catch (SQLException ex) {
                    Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listQuestion;
    }

    @Override
    public List<Question> findByAccect() {
        ResultSet rs = this.questionDAO.findByAccect();
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    MemberService mb = new MemberServiceImpl();
                    SubjectService ss = new SubjectServiceImpl();
//                    Subject subject = ss.findById(rs.getString("suject_id"));
                    Member member = mb.findById(rs.getInt("member_id"));
                    Question qt = new Question(rs.getInt("question_id"), rs.getString("subject_id"),
                            rs.getInt("member_id"), rs.getString("question_name"), rs.getString("question_decription"),
                            rs.getString("question_content"), rs.getDate("question_date"), rs.getInt("question_accept"));
                    listQuestion.add(qt);
                } catch (SQLException ex) {
                    Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listQuestion;
    }
//    public static void main(String[] args) {
//        QuestionService qtsv = new QuestionServiceImpl(null);
//        Question question = new Question();
//        List<Question> list = qtsv.findByAccect();
//        
//        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i).getQuestionName());
//    }}

//    public static void main(String[] args) {
//        SubjectService sb = new SubjectServiceImpl(null);
//       Subject s =  sb.findById("2");
//        System.out.println(s.getSubjectName());
//    }
    @Override
    public ConnectionPool getConnectionPool() {
        return this.questionDAO.getConnectionPool();
    }

    @Override
    public void releaseConnection() {
        this.questionDAO.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.questionDAO.refreshConnectionPool();
    }

    @Override
    public Question findById(int id) {
        Question question = null;
        try {
            ResultSet rs = this.questionDAO.findById(id);
            while (rs.next()) {
                int questionID = rs.getInt("question_id");
                String quesionName = rs.getString("question_name");
                String questionDecription = rs.getString("question_decription");
                String questionContent = rs.getString("question_content");
                Integer questionvote = rs.getInt("vote");
                Integer questionaccept = rs.getInt("question_accept");
                Date questionDate = rs.getDate("question_date");
                memberService = new MemberServiceImpl();
                Member m = memberService.findById(rs.getInt("member_id"));
                subjectService = new SubjectServiceImpl();
                Subject sb = subjectService.findById(rs.getString("subject_id"));
                question = new Question(questionID, sb, m, quesionName, questionDecription, questionContent, questionDate, questionaccept, questionvote);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question;
    }
//    public static void main(String[] args) {
//        QuestionService questionService = new QuestionServiceImpl(null);
//        Question question = questionService.findById(11);
//        System.out.println(question.getQuestionName());
//    }

    @Override
    public boolean delAcceptQuestion(int id) {
        boolean rs = questionDAO.delAcceptQuestion(id);
        Question q = new Question(id);
        return rs;
    }

    @Override
    public List<Question> find(int limit, int start) {
        ResultSet rs = this.questionDAO.find(limit, start);
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                int questionID = rs.getInt("question_id");
                String quesionName = rs.getString("question_name");
                String questionDecription = rs.getString("question_decription");
                String questionContent = rs.getString("question_content");
                Date questionDate = rs.getDate("question_date");
                memberService = new MemberServiceImpl();
                Member m = memberService.findById(rs.getInt("member_id"));
                subjectService = new SubjectServiceImpl();
                Subject sb = subjectService.findById(rs.getString("subject_id"));
                Question question = new Question(questionID, sb, m, quesionName, questionDecription, questionContent, questionDate);
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.questionDAO.releaseConnection();
        return listQuestion;
    }
    
    @Override
    public List<Question> findBySubjectLimit(String subjectId, int limit, int start) {
        ResultSet rs = this.questionDAO.findByIdSubject(subjectId, limit, start);
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                int questionID = rs.getInt("question_id");
                String quesionName = rs.getString("question_name");
                String questionDecription = rs.getString("question_decription");
                String questionContent = rs.getString("question_content");
                Date questionDate = rs.getDate("question_date");
                memberService = new MemberServiceImpl();
                Member m = memberService.findById(rs.getInt("member_id"));
                subjectService = new SubjectServiceImpl();
                Subject sb = subjectService.findById(rs.getString("subject_id"));
                Question question = new Question(questionID, sb, m, quesionName, questionDecription, questionContent, questionDate);
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.questionDAO.releaseConnection();
        return listQuestion;
    }

    @Override
    public int totalQuestion() {
        int total = 0;
        try {
            ResultSet rs = this.questionDAO.findAll();
            while (rs.next()) {
                total++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.questionDAO.releaseConnection();
        return total;
    }

    @Override
    public int totalQuestionById(String subjectId) {
        int total = 0;
        try {

            ResultSet rs = questionDAO.findByIdSubject(subjectId);
            while (rs.next()) {
                total++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public List<Question> search(String[] search) {
        ResultSet rs = this.questionDAO.search(search, 4, 0);
        List<Question> listQuestion = new ArrayList<>();
        try {
            while (rs.next()) {
                int questionID = rs.getInt("question_id");
                String quesionName = rs.getString("question_name");
                String questionDecription = rs.getString("question_decription");
                String questionContent = rs.getString("question_content");
                Date questionDate = rs.getDate("question_date");
                memberService = new MemberServiceImpl();
                Member m = memberService.findById(rs.getInt("member_id"));
                subjectService = new SubjectServiceImpl();
                Subject sb = subjectService.findById(rs.getString("subject_id"));
                Question question = new Question(questionID, sb, m, quesionName, questionDecription, questionContent, questionDate);
                listQuestion.add(question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.questionDAO.releaseConnection();
        return listQuestion;
    }
}
