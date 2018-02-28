/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;
import vn.edu.ctu.forum.models.pojos.Question;

/**
 *
 * @author Ew
 */
public interface QuestionDAO extends BaseDAO {

    //Them Question
    public boolean addQuestion(Question question);

    //Sua Question
    public boolean editQuetion(Question question);

    //Accept Question
    public boolean editQuestionAccept(int id);
    
    public boolean voteUp(int id, int vote);

    public boolean voteDown(int id, int vote);

    //Xoa Question
    public boolean delQuetion(int id);

    //delete member accept
    public boolean delAcceptQuestion(int id);

    //Lay toan bo danh sach
    public ResultSet findAll();

    //Lay theo Id
    public ResultSet findByIdMember(int id);

     public ResultSet findById(int id);

    //Lay Question chua 
    public ResultSet findByAccect();

    //Find ID Subject
    public ResultSet findByIdSubject(String id);
    
    public ResultSet findByIdSubject(String id, int litmit, int start);
    
    public ResultSet find(int limit, int start);
    
    public ResultSet search(String[] search,int litmit, int start);
}
