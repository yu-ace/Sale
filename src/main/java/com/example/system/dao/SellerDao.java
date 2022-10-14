package com.example.system.dao;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;
import com.example.system.model.SalesOrder;
import com.example.system.model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerDao {
    public static void save(List<Seller> sellerList){
        String str = JSONUtil.toJsonStr(sellerList);
        FileWriter fileWriter =new FileWriter(FileUtil.getUserHomePath() + "/sale/Seller.dat");
        fileWriter.write(str);
    }

    public static List<Seller> load(){
        try{
            FileReader fileReader =new FileReader(FileUtil.getUserHomePath() + "/sale/Seller.dat");
            String str = fileReader.readString();
            List<Seller> sellerList = JSONUtil.toList(str, Seller.class);
            return sellerList;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
