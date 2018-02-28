/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;
import java.util.List;
import vn.edu.ctu.forum.models.pojos.Image;
import vn.edu.ctu.forum.models.pojos.Member;
/**
 *
 * @author NTD
 */
public interface MemberService extends BaseService{
    
    public boolean addMember(Member m);   
    public boolean editMember(Member m);
    public boolean delMember();
    //delete member accept
    public boolean delAcceptMember(int id);
    // lay danh sach member chua appcept
    public boolean  editAcceptMember(int id);
    
    public List<Member> findAcceptMember();
    //lay tat ca
    public List<Member> findAll();
    // lay danh  sach theo phan trang
    public List<Member> find(int start, int limit);
    //public tim theo id member
    public Member findById(int id);
    public Member findByEmail(String email);
    // login
    public Member login(String email, String pass);
    // update avatar member
    public boolean updateAvatar(int memberId, Image image);
    // change pass
    public boolean changePass(int memberID, String passCurrent, String passNew);
}
