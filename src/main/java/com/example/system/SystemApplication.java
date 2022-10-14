package com.example.system;

import com.example.system.model.SalesOrder;
import com.example.system.service.SalesOrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    static Scanner scanner =new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        while(true){
            printHelp();
            String str = scanner.next();
            if(str.equals("1")){
                System.out.println("请输入订单id");
                int id = scanner.nextInt();
                System.out.println("请输入订单名字");
                String name = scanner.next();
                System.out.println("请输入订单金额");
                double amount = scanner.nextDouble();
                System.out.println("请输入销售员姓名");
                String sellerName = scanner.next();
                SalesOrderService.newSalesOrder(id,name,amount,sellerName);
            }else if(str.equals("2")){
                List<SalesOrder> salesOrderList = SalesOrderService.getSalesOrderList();
                for(SalesOrder salesOrder : salesOrderList){
                    System.out.println(salesOrder.getId() + "\t" + salesOrder.getName() + "\t"
                            + salesOrder.getAmount() + "\t" + salesOrder.getSellerName() + "\t"
                            + salesOrder.getStatus());
                }
            }else if(str.equals("3")){
                System.out.println("请输入你的姓名");
                String name = scanner.next();
                System.out.println("本次提取的金额为：" + SalesOrderService.salary(name));;
            }else if(str.equals("4")){
                System.out.println("请输入你的姓名");
                String name = scanner.next();
                System.out.println("你提取的订单编号和名字为：" + SalesOrderService.extract(name).getId() + "\t"
                        + SalesOrderService.extract(name).getName());
            }else if(str.equals("q")){
                System.exit(0);
            }
        }
    }

    public static void printHelp(){
        System.out.println("欢迎使用销售管理系统");
        System.out.println("输入1 录入销售订单");
        System.out.println("输入2 查看订单列表");
        System.out.println("输入3 提取薪水");
        System.out.println("输入4 查看提取记录");
        System.out.println("输入q 退出");
    }
}
