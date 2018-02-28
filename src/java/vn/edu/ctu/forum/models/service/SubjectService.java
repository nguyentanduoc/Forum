/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import java.util.List;
import vn.edu.ctu.forum.models.pojos.Subject;
import vn.edu.ctu.forum.models.pojos.Image;
/**
 *
 * @author PC
 */
public interface SubjectService extends BaseService{
    
    //them chu de
    public boolean addSubject(Subject sj, Image img);
    //sua chu de
    public boolean edtSubject(Subject sj);
    //xoa chu de
    public boolean delSubject(Subject sj);
    //lay tat ca chu de
    public List<Subject> findAll();
    //lay danh sach theo phan trang
    public List<Subject> find(int start, int limit);
    //lay danh sach theo ID
    public Subject findById(String id);
}
