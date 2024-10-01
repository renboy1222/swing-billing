/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.gui.panel.BillingData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface BillingDataDAO {

    //    list of the Customer
    public List<BillingData> selectBillingData();

    public ArrayList<BillingData> selectBillingDataDetails(Long invoiceID);

    public List<BillingData> selectBillingDataByToday();

    public ArrayList<BillingData> selectBillingDataByYesterday();
    
    public ArrayList<BillingData> selectBillingDataByCurrentWeek();
    
    public ArrayList<BillingData> selectBillingDataByCurrentMonth();
    
    public ArrayList<BillingData> selectBillingDataByTodayUser();
    
        public ArrayList<BillingData> selectBillingDataByYesterdayUser();
    
    public ArrayList<BillingData> selectBillingDataByCurrentWeekUser();
    
    public ArrayList<BillingData> selectBillingDataByCurrentMonthUser();
    
    public ArrayList<BillingData> selectBillingDataUser();
}
