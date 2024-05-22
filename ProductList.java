package com.exercise.demo;
import java.util.ArrayList;

public class ProductList {
    // 成员变量是ArrayList
    private ArrayList<String[]> products = new ArrayList<String[]>();

    // ProductList类的构造方法，初始化商品列表
    public ProductList() {
        products.add(new String[] { "1", "生命药剂", "2" });
        products.add(new String[] { "2", "暴击药剂", "2" });
        products.add(new String[] { "3", "闪避符咒", "3" });
    }

    // 根据索引输入药品名称
    public String getProductName(int index) {
        return products.get(index)[1];
    }

    // 写一个输入商品序号的方法
    public void inputProduct(String number, Package package1, Creature player) {
        for (int j = 0; j < products.size(); j++) {
            if (number.equals(products.get(j)[0])) {
                System.out.println("商品名：" + products.get(j)[1] + "，价格：" + products.get(j)[2]);
                player.setGold(player.getGold() - Integer.parseInt(products.get(j)[2]));
                products.remove(j);
                System.out.println("购买成功，剩余金币：" + player.getGold());
                break;
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

    public void judgePrint(Package package1, Creature player) {
        if (this.getProducts().size() == 0) {
            System.out.println("商品售罄");
            while (true) {
                System.out.println("Do you want to continue?Type'y'to continue");
                String input = System.console().readLine();
                if (!(input.equals("y"))) {
                    System.out.println("输入错误，请重新输入：");
                    continue;
                } else
                    break;
            }

        } else {
            this.outputProduct();
            if (player.getGold() < 2) {
                System.out.println("金币不足");
                while (true) {
                    System.out.println("Do you want to continue?Type'y'to continue");
                    String input = System.console().readLine();
                    if (!(input.equals("y"))) {
                        System.out.println("输入错误，请重新输入：");
                        continue;
                    } else
                        break;
                }
            } else {
                while (true) {
                    System.out.println("Type number to buy product.Type'y'to continue");
                    String input = System.console().readLine();
                    // 判断输入的是否为剩下药品数字
                    if (input.matches("\\d+")) {
                        boolean flag1 = false;
                        for (int j = 0; j < this.getProducts().size(); j++) {
                            if (input.equals(this.getProducts().get(j)[0])) {
                                flag1 = true;
                                break;
                            }
                        }
                        if (!flag1) {
                            System.out.println("商品不存在，请重新输入序号：");
                            continue;
                        }
                        int number = Integer.parseInt(input);
                        if (number == 3 && player.getGold() < 3) {
                            System.out.println("金币不足,无法购买，请重新输入序号：");
                            continue;
                        } else {
                            // 能够购买的情况
                            this.inputProduct(input, package1, player);
                            int[] skill = { 0, 0, 0 };
                            for (int j = 0; j < 3; j++) {
                                if (j == number - 1) {
                                    skill[j] = 1;
                                } else
                                    skill[j] = 0;
                            }
                            package1.setSkill(skill);// 不直接给玩家，放入背包中
                            break;
                        }
                    } else if (input.equals("y")) {
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入:");
                        continue;
                    }
                }
            }
        }
    }

}
