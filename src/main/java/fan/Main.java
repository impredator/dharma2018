package fan;

import java.util.Scanner;
public class Main {
    public static void main(String [] agrs) {
        Grocery grocery = new Grocery();
        Scanner sb = new Scanner(System.in);
        boolean flag1 = true;
        int choose;
        while (flag1) {
            System.out.println("请选择操作：1.进货  2.下架货物  3.寻找货物  4.修改货物信息  5.退出：");
            choose = sb.nextInt();
            if (choose == 1)
                grocery.setGoods();
            if (choose == 2)
                grocery.remove();
            if (choose == 3)
                grocery.find();
            if (choose == 4)
                grocery.replace();
            if (choose == 5)
                flag1 = false;
        }
    }
}
