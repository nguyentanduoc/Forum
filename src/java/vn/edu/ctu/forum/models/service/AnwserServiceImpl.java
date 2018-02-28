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
import vn.edu.ctu.forum.models.pojos.Answer;
import vn.edu.ctu.forum.models.untils.ConnectionPool;
import vn.edu.ctu.forum.models.dao.AnwserDAO;
import vn.edu.ctu.forum.models.dao.AnwserDAOImpl;
import vn.edu.ctu.forum.models.pojos.Member;
/**
 *
 * @author NTD
 */
public class AnwserServiceImpl implements AnwserService{

    private final AnwserDAO answerDAO;

    public AnwserServiceImpl() {
        this.answerDAO = new AnwserDAOImpl();
    }

    @Override
    public boolean addAnwser(Answer anwser) {
        return this.answerDAO.addAnwer(anwser);
    }

    @Override
    public List<Answer> findByIdQuesion(int questionId) {
        ResultSet rs = this.answerDAO.findByIdQuestion(questionId);
        List<Answer> list=null;
        if(rs!=null){
            try {
                list = new ArrayList<>();
                while(rs.next()){
                    int answerId = rs.getInt("anwser_id");
                    int memberId = rs.getInt("member_id");
                    String answerContent = rs.getString("anwser_content");
                    Date dateUpdate = rs.getDate("anwser_date");
                    MemberService memberService = new MemberServiceImpl();
                    Member m = memberService.findById(memberId);
                    Answer a = new Answer(answerId,questionId,answerContent,dateUpdate,m);
                    list.add(a);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AnwserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        AnwserService anwserService = new AnwserServiceImpl(null);
//        List<Answer> listAnswer = anwserService.findByIdQuesion(3);
//        for(int i =0; i< listAnswer.size();i++){
//            System.out.println(listAnswer.get(i).getAnwserContent());
//            System.out.println(listAnswer.get(i).getMember().getMemberName());
//             System.out.println("______________");
//        }
//    }
    @Override
    public ConnectionPool getConnectionPool() {
      return this.answerDAO.getConnectionPool();
      
    }

    @Override
    public void releaseConnection() {
        this.answerDAO.releaseConnection();
    }

    @Override
    public void refreshConnectionPool() {
        this.answerDAO.refreshConnectionPool();
    }
    
}
