package com.exercise.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class NewProductList {
    private ObservableList<Product> data =
            FXCollections.observableArrayList(
                    new Product(1, "生命药剂", "恢复冒险者2点生命值", 2),
                    new Product(2, "暴击药剂", "如果冒险者购买后,下一关卡发生了战斗并获胜,可以让对手生命值减少3", 2),
                    new Product(3, "闪避符咒", "如果冒险者购买后,下一关卡发生了战斗并战败,可以免除生命值的减少", 3)
            );

    //构造方法
    public NewProductList() {
        data =
                FXCollections.observableArrayList(
                        new Product(1, "生命药剂", "恢复冒险者2点生命值", 2),
                        new Product(2, "暴击药剂", "如果冒险者购买后,下一关卡发生了战斗并获胜,可以让对手生命值减少3", 2),
                        new Product(3, "闪避符咒", "如果冒险者购买后,下一关卡发生了战斗并战败,可以免除生命值的减少", 3)
                );
    }

    public ObservableList<Product> getData() {
        return data;
    }

    public void setData(ObservableList<Product> data) {
        this.data = data;
    }

    public void purchase(Product product, Package myPackage, Creature player) {
        if (player.getGold() < 2 || product.getIndex() == 3 && player.getGold() < 3) {
            // 如果金币不足，显示错误消息
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You don't have enough gold!");
            alert.showAndWait();
        } else {
            // 如果金币足够，购买商品
            myPackage.addProduct(product);
            player.setGold(player.getGold() - product.getPrice());
            // 从Money的角度将金币减少
            Money money = new Money();
            money.setValue(0);
            money.setRealCoin(true);
            Boolean finish = false;
            if (product.getIndex() == 2) {
                for (int i = 0; i < 20; i++) {//20是最高的金币数量
                    if (player.getMoney()[i] == null) {
                        continue;
                    }
                    if (player.getMoney()[i].getValue() == 2) {
                        player.setMoney(money, i);
                        finish = true;
                        break;
                    }
                }
                if (!finish) {
                    int count = 0;
                    for (int i = 0; i < 20; i++) {//20是最高的金币数量
                        if (player.getMoney()[i] == null) {
                            continue;
                        }
                        if (player.getMoney()[i].getValue() == 1) {
                            player.setMoney(money, i);
                            count++;
                        }
                        if (count == 2) {
                            break;
                        }
                    }
                }

            } else {
                int value = 0;
                boolean finish1 = false;
                for (int i = 0; i < 20; i++) {//20是最高的金币数量
                    if (player.getMoney()[i] == null) {
                        continue;
                    }
                    if (player.getMoney()[i].getValue() == 2) {
                        player.setMoney(money, i);
                        value += 2;
                        finish1 = true;
                        break;
                    }
                }
                Money money1 = new Money();
                money1.setValue(1);
                money1.setRealCoin(true);
                for (int i = 0; i < 20; i++) {//20是最高的金币数量
                    if (player.getMoney()[i] == null) {
                        continue;
                    }
                    if (player.getMoney()[i].getValue() == 2) {
                        player.setMoney(money1, i);
                        value += 2;
                        break;
                    }
                }
                if (value == 4) {
                    finish = true;
                }

                if (!finish) {
                    int count = 0;
                    if (!finish1) {
                        for (int i = 0; i < 20; i++) {//20是最高的金币数量
                            if (player.getMoney()[i] == null) {
                                continue;
                            }
                            if (player.getMoney()[i].getValue() == 1) {
                                player.setMoney(money, i);
                                count++;
                            }
                            if (count == 3) {
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; i < 20; i++) {
                            if (player.getMoney()[i] == null) {
                                continue;
                            }
                            if (player.getMoney()[i].getValue() == 1) {
                                player.setMoney(money, i);
                                count++;
                            }
                            if (count == 1) {
                                break;
                            }
                        }
                    }

                }
            }
            //将商品从商品列表中移除
            data.remove(product);
        }
    }


}
