/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

import java.util.Date;

/**
 *
 * @author Ew
 */
public class Answer {
    private Integer anwserId;
    private Integer questionId;
    private Integer memberId;
    private String anwserContent;
    private Date anwserDate;
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Answer(Integer questionId, Integer memberId, String anwserContent) {
        this.questionId = questionId;
        this.memberId = memberId;
        this.anwserContent = anwserContent;
    }

    public Answer(Integer anwserId, Integer questionId, String anwserContent, Date anwserDate, Member member) {
        this.anwserId = anwserId;
        this.questionId = questionId;
        this.anwserContent = anwserContent;
        this.anwserDate = anwserDate;
        this.member = member;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    
    
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    
    

    public Integer getAnwserId() {
        return anwserId;
    }

    public void setAnwserId(Integer anwserId) {
        this.anwserId = anwserId;
    }

    public String getAnwserContent() {
        return anwserContent;
    }

    public void setAnwserContent(String anwserContent) {
        this.anwserContent = anwserContent;
    }

    public Date getAnwserDate() {
        return anwserDate;
    }

    public void setAnwserDate(Date anwserDate) {
        this.anwserDate = anwserDate;
    }    
}
