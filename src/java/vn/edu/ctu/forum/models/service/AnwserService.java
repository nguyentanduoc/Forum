/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.util.List;
import vn.edu.ctu.forum.models.pojos.Answer;
/**
 *
 * @author NTD
 */
public interface AnwserService extends BaseService {
    
    public boolean addAnwser(Answer anwser);
    public List<Answer> findByIdQuesion(int questionId);
}
