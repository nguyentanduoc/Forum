/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.util.List;
import vn.edu.ctu.forum.models.pojos.Question;

/**
 *
 * @author Administrator
 */
public interface QuestionService extends BaseService {

    public boolean addQuestion(Question question);

    //Sua Question
    public boolean editQuetion(Question question);

    //Accept Question
    public boolean editQuestionAccept(int id);

    public boolean voteUp(int id, int vote);

    public boolean voteDown(int id, int vote);

    //Xoa Question
    public boolean delQuetion(int id);

    //Lay toan bo danh sach
    public List<Question> findAll();

    //Lay theo Id
    public Question findById(int id);

    public List<Question> findByIdMember(int id);

    //Lay Question chua 
    public List<Question> findByAccect();

    //delete member accept
    public boolean delAcceptQuestion(int id);

    //find limit
    public List<Question> find(int limit, int start);

    public int totalQuestionById(String subjectId);

    public List<Question> findBySubjectLimit(String subjectId, int limit, int start);

    public List<Question> search(String[] search);

    public int totalQuestion();
}
