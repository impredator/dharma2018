package fan;

import java.util.HashMap;
import java.util.Scanner;

public class Grocery {
    private HashMap<String,goods> grocery = new HashMap<>();
    Scanner sb = new Scanner(System.in);
    int flag = 1;
    public Grocery(){

    }


    public void find(){
        System.out.print("请输入需要查找的商品名字：");
        String name = sb.next();
        System.out.print("编号：" + grocery.get(name).getNumber() + "  ");
        System.out.print("商品名：" + grocery.get(name).getname() + "  ");
        System.out.print("单价：" + grocery.get(name).getPrice()+ "  ");
        System.out.println("库存：" + grocery.get(name).getRemain());
    }
    public void remove(){
        System.out.print("请输入需要下架的商品名字：");
        String name = sb.next();
        grocery.remove(name);
        System.out.println(name + "已经下架");
    }
    public void setGoods(){
        while (flag > 0) {
            System.out.println("请分别输入商品编号、商品名、价格和进货数：");
            int number = sb.nextInt();
            String name = sb.next();
            double price = sb.nextDouble();
            int remain = sb.nextInt();
            grocery.put(name,new goods(number, name, price, remain));
            System.out.println("是否继续进货：1.是  2。否");
            int i = sb.nextInt();
            if (i == 2) {
                flag = -1;
            }
        }
        System.out.println("进货完成");
    }
    public void replace(){
        System.out.print("请输入需要修改货物的货物名：");
        String name = sb.next();
        System.out.println("请输入需要修改的项目：1.商品编号  2.商品名  3.价格  4.进货数：");
        int number;
        String name1;
        double price;
        int remain;
        int item = sb.nextInt();
        if (item == 1){
            System.out.print("请输入新的编号：");
            number = sb.nextInt();
            grocery.get(name).setNumber(number);
        }
        if (item == 2){
            System.out.print("请输入货物新名称：");
            name1 = sb.next();
            grocery.get(name).setName(name1);
        }
        if (item == 3){
            System.out.print("请输入更改后单价：");
            price = sb.nextDouble();
            grocery.get(name).setPrice(price);
        }
        if (item == 4){
            System.out.println("请输入最新库存：");
            remain = sb.nextInt();
            grocery.get(name).setRemain(remain);
        }
        System.out.println("修改成功");
    }

}
