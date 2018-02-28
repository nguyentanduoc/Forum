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
public class Image {
    private Integer imageId;
    private String imageAlt;
    private String imageSrc;
    private Date imageDate;

    public Image(String imageAlt, String imageSrc, Date imageDate) {
        this.imageAlt = imageAlt;
        this.imageSrc = imageSrc;
        this.imageDate = imageDate;
    }

    public Image(String imageAlt, String imageSrc) {
        this.imageAlt = imageAlt;
        this.imageSrc = imageSrc;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Date getImageDate() {
        return imageDate;
    }

    public void setImageDate(Date imageDate) {
        this.imageDate = imageDate;
    }
    
}
