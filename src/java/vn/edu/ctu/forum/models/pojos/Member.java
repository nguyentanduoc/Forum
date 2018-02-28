/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

import java.util.Date;

/**
 *
 * @author NTD
 */
public class Member {

    private Integer memberId;
    private String memberName;
    private String memberEmail;
    private String memberPass;
    private String memberSex;
    private Date memberBirthDay;
    private String strDate;
    private boolean memberIsAdmin;
    private Date memberDateRegister;
    private String memberIntroduce;
    private boolean memberAccept;
    
    public Member(Integer memberId, boolean memberAccept){
    this.memberId = memberId;
    this.memberAccept = memberAccept;
    }

    public Member(Integer memberId, String memberName, String memberEmail, String memberPass, String memberSex, Date memberBirthDay, boolean memberIsAdmin, Date memberDateRegister, String memberIntroduce, boolean memberAccept) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPass = memberPass;
        this.memberSex = memberSex;
        this.memberBirthDay = memberBirthDay;
        this.memberIsAdmin = memberIsAdmin;
        this.memberDateRegister = memberDateRegister;
        this.memberIntroduce = memberIntroduce;
        this.memberAccept = memberAccept;
    }

    public Member(String memberName, String memberEmail, String memberPass) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPass = memberPass;
    }

    public Member(String memberName, String memberEmail, String memberPass, String memberSex, Date memberBirthDay, String memberIntroduce) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPass = memberPass;
        this.memberSex = memberSex;
        this.memberBirthDay = memberBirthDay;
        this.memberIntroduce = memberIntroduce;
    }

    public Member(Integer memberId, String memberName, String memberSex, String strDate, String memberIntroduce) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberSex = memberSex;
        this.strDate = strDate;
        this.memberIntroduce = memberIntroduce;
    }

    public Member() {
    }
    
    public Member(Integer MemberId){
    this.memberId = MemberId;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    public Date getMemberBirthDay() {
        return memberBirthDay;
    }

    public void setMemberBirthDay(Date memberBirthDay) {
        this.memberBirthDay = memberBirthDay;
    }

    public boolean isMemberIsAdmin() {
        return memberIsAdmin;
    }

    public void setMemberIsAdmin(boolean memberIsAdmin) {
        this.memberIsAdmin = memberIsAdmin;
    }

    public Date getMemberDateRegister() {
        return memberDateRegister;
    }

    public void setMemberDateRegister(Date memberDateRegister) {
        this.memberDateRegister = memberDateRegister;
    }

    public String getMemberIntroduce() {
        return memberIntroduce;
    }

    public void setMemberIntroduce(String memberIntroduce) {
        this.memberIntroduce = memberIntroduce;
    }

    public boolean isMemberAccept() {
        return memberAccept;
    }

    public void setMemberAccept(boolean memberAccept) {
        this.memberAccept = memberAccept;
    }

}
