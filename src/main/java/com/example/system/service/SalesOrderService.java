package com.example.system.service;

import com.example.system.dao.SalesOrderDao;
import com.example.system.dao.SellerDao;
import com.example.system.model.SalesOrder;
import com.example.system.model.Seller;

import java.util.List;

public class SalesOrderService {
    static List<SalesOrder> salesOrderList = SalesOrderDao.load();
    static List<Seller> sellerList = SellerDao.load();

    public static void newSalesOrder(int id,String name,double amount,String sellerName){
        SalesOrder salesOrder =new SalesOrder();
        salesOrder.setId(id);
        salesOrder.setName(name);
        salesOrder.setAmount(amount);
        salesOrder.setSellerName(sellerName);
        salesOrder.setStatus(0);
        salesOrderList.add(salesOrder);
        SalesOrderDao.save(salesOrderList);

        Seller seller = new Seller();
        seller.setName(sellerName);
        seller.setPrice(amount);
        sellerList.add(seller);
        SellerDao.save(sellerList);
    }

    public static List<SalesOrder> getSalesOrderList() {
        return salesOrderList;
    }

    public static double salary(String sellerName){
        double sum = 0;
        double salary = 0;
        for(SalesOrder salesOrder : salesOrderList){
            if(salesOrder.getSellerName().equals(sellerName)){
                if(salesOrder.getStatus() == 0){
                    sum =sum + salesOrder.getAmount();
                    salary = sum * 0.1;
                    salesOrder.setStatus(1);
                    SalesOrderDao.save(salesOrderList);
                }
            }
        }
        return salary;
    }



    public static SalesOrder extract(String sellerName){
        for(SalesOrder salesOrder : salesOrderList){
            if(salesOrder.getSellerName().equals(sellerName)){
                if(salesOrder.getStatus() == 1){
                    return salesOrder;
                }
            }
        }
        return null;
    }

//    public static SalesOrder max(){
//        for(SalesOrder salesOrder :salesOrderList){
//
//        }
//    }
//
//    public static double[] total(){
//        double[] total = new double[50];
//        for(Seller seller : sellerList){
//
//        }
//    }
}
