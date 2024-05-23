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
            //将商品从商品列表中移除
            data.remove(product);
        }
    }


}
