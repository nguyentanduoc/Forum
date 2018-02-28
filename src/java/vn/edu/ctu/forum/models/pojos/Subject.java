/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.pojos;

/**
 *
 * @author Admin
 */
public class Subject {
    
    private String subjectId;
    private String subjectName;
    private int imageId;
    private Image image;

    public Subject(String subjectId, String subjectName, Image image) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.image = image;
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Subject(String subjectId, String subjectName, int imageId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.imageId = imageId;
    }  

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public Subject(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public Subject(){
    
    }
    
}
