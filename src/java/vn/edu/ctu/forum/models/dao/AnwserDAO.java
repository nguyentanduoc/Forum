/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;
import vn.edu.ctu.forum.models.pojos.Answer;
/**
 *
 * @author NTD
 */
public interface AnwserDAO extends BaseDAO{
    
    //add anwer get id
    public boolean addAnwer(Answer anwser);
    
    //find by question
    public ResultSet findByIdQuestion(int subjectId);
    
}
