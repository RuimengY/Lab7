package com.exercise.demo;

public class Package {
    private int[] skill = new int[3];

    public int[] getSkill() {
        return skill;
    }

    public void setSkill(int[] skill) {
        this.skill = skill;
    }

    // 判断背包中的skill是否用于下一关
    public void skillFromPackage(ProductList productList, Creature player) {
        // 如果背包中什么都没有直接跳过
        boolean flag = false;
        for (int i = 0; i < skill.length; i++) {
            if (skill[i] == 1) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            return;
        }
        // 输出背包中的技能
        System.out.println("背包中现有的技能：");
        for (int i = 0; i < 3; i++) {
            if (skill[i] != 0) {
                if (i == 0) {
                    System.out.println("技能1 " + ": 生命药剂");
                } else if (i == 1) {
                    System.out.println("技能2 " + ": 攻击药剂");
                } else
                    System.out.println("技能3 " + ": 防御药剂");
            }
        }
        System.out.println("是否将背包中的技能用于下一关?y/n");
        while (true) {
            String input = System.console().readLine();
            if (input.equals("y")) {
                while (true) {
                    System.out.println("请输入要用于下一关的技能序号");
                    int number = Integer.parseInt(System.console().readLine());
                    if (number < 1 || number > 3 || skill[number - 1] == 0) {
                        System.out.println("输入错误，请重新输入：");
                    } else {// 将背包中的技能用于下一关
                        player.setSkill(number - 1);
                        skill[number - 1] = 0;
                        break;
                    }
                }
                break;
            } else if (input.equals("n")) {
                break;
            } else {
                System.out.println("输入错误，请重新输入：");
            }
        }

    }
    public void addProduct(Product product){
        for (int i = 0; i < skill.length; i++) {
            if (i == product.getIndex() - 1){
                skill[i] = 1;
                break;
            }
        }
    }
}
