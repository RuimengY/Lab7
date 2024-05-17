import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {
    // 成员变量是ArrayList
    private ArrayList<String[]> products = new ArrayList<String[]>();

    // ProductList类的构造方法，初始化商品列表
    public ProductList() {
        products.add(new String[] { "1", "生命药剂", "2" });
        products.add(new String[] { "2", "暴击药剂", "2" });
        products.add(new String[] { "3", "闪避符咒", "3" });
    }

    // 写一个输入商品序号的方法
    public void inputProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean hasProduct = false;
        while (!hasProduct) {
            System.out.print("请输入商品序号，如果输入y表示退出:");
            String input = scanner.nextLine();
            // 当输入为y的时候直接跳出循环
            if (input.equals("y")) {
                break;
            }
            for (int j = 0; j < products.size(); j++) {
                if (input.equals(products.get(j)[0])) {
                    System.out.println("商品名：" + products.get(j)[1] + "，价格：" + products.get(j)[2]);
                    products.remove(j);
                    hasProduct = true;
                    break;
                }
            }
            if (!hasProduct) {
                System.out.println("没有该商品，请重新输入");
            }
        }
    }

    // 输出还剩下的商品的方法
    public void outputProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println("商品序号：" + products.get(i)[0] + "  商品名：" + products.get(i)[1] + "  商品价格："
                    + products.get(i)[2]);
        }
    }

    // 写一个productlist成员变量的get方法
    public ArrayList<String[]> getProducts() {
        return products;
    }

}
