package com.example.system.dao;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;
import com.example.system.model.SalesOrder;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderDao {
    public static void save(List<SalesOrder> salesOrderList){
        String str = JSONUtil.toJsonStr(salesOrderList);
        FileWriter fileWriter =new FileWriter(FileUtil.getUserHomePath() + "/sale/sale.dat");
        fileWriter.write(str);
    }

    public static List<SalesOrder> load(){
        try{
            FileReader fileReader =new FileReader(FileUtil.getUserHomePath() + "/sale/sale.dat");
            String str = fileReader.readString();
            List<SalesOrder> salesOrderList = JSONUtil.toList(str, SalesOrder.class);
            return salesOrderList;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
