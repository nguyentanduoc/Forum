/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;
import vn.edu.ctu.forum.models.pojos.Subject;

/**
 *
 * @author PC
 */
public interface SubjectDAO extends BaseDAO{
    //them Subject
    public boolean addSubject(Subject sb);
    //sua Subject 
    public boolean editSubject(Subject sb);
    //xoa Subject
    public boolean delSubject(String id);
    // select all
    public ResultSet findAll();
    // tim co dieu kien
    public ResultSet findByID(String id);
   
}
