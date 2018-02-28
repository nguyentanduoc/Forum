/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

/**
 *
 * @author NTD
 */
public class MemberImage {
    private Integer imageID;
    private Integer memberID;
    private Image imagePojos;
    private Member mamberPojos;

    public MemberImage(Integer imageID, Integer memberID) {
        this.imageID = imageID;
        this.memberID = memberID;
    }
    
    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public Image getImagePojos() {
        return imagePojos;
    }

    public void setImagePojos(Image imagePojos) {
        this.imagePojos = imagePojos;
    }

    public Member getMamberPojos() {
        return mamberPojos;
    }

    public void setMamberPojos(Member mamberPojos) {
        this.mamberPojos = mamberPojos;
    }
    
}
