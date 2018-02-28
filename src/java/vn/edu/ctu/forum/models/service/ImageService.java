/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.service;

import vn.edu.ctu.forum.models.pojos.Image;

/**
 *
 * @author NTD
 */
public interface ImageService extends BaseService{
    
    //insert image
    public boolean addImage(Image image);
    //get Image
    public Image findById(int id);
    //get image member
    public Image findByIdMember(int id);
    //add get last id 
    public Integer addGetLastId(Image image);
}
