/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.ctu.forum.models.dao;

import java.sql.ResultSet;
import vn.edu.ctu.forum.models.pojos.Image;

/**
 *
 * @author NTD
 */
public interface ImageDAO extends BaseDAO{
    // insert image
    public boolean add(Image img);
    // find image
    public ResultSet findById(int id);
    //get Last id
    public Integer getLastID(Image img);
}
