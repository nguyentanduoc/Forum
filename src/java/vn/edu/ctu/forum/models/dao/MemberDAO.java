/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;
import vn.edu.ctu.forum.models.pojos.Member;
import java.sql.ResultSet;

/**
 *
 * @author NTD
 */
public interface MemberDAO extends BaseDAO{
    //them member
    public boolean addMember(Member member);
    //update member
    public boolean editMember(Member member);
    //accept member
    public boolean editAcceptMember(int id);
    //delete member
    public boolean delMember(int id);
    //delete member accept
    public boolean delAcceptMember(int id);
    // lay danh sach member
    public ResultSet findAll();
    // lay member theo id
    public ResultSet findById(int id);

    public ResultSet findByEmail(String email);

    public ResultSet findByAccept();
    //chavge pass
    public boolean changePass(int id,String pass);
}
