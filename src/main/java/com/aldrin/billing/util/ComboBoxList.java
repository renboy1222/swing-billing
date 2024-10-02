/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.util;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author ALDRIN B. C.
 */

public class ComboBoxList {
    private Long id;
    private String name;
    private Date timeStamp;
    
    public ComboBoxList(Long id, String name){
        this.id =id;
        this.name =name;
    }
    
     public ComboBoxList(Long id, Date timeStamp){
        this.id =id;
        this.timeStamp =timeStamp;
    }
    
    public void setSelectedId(ArrayList<ComboBoxList> comboBoxList,String id,javax.swing.JComboBox cb){
        for(ComboBoxList name:comboBoxList){
            if(name.getId().toString().equals(id)){
                cb.setSelectedItem(name);
            }
        }
    }
    
    public String toString(){
        return this.getName();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
