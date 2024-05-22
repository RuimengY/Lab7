package com.exercise.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class newProductList {
    private ObservableList<Product> data =
            FXCollections.observableArrayList(
                    new Product(1, "生命药剂", "恢复冒险者2点生命值", 2),
                    new Product(2, "暴击药剂", "如果冒险者购买后,下一关卡发生了战斗并获胜,可以让对手生命值减少3", 2),
                    new Product(3, "闪避符咒", "如果冒险者购买后,下一关卡发生了战斗并战败,可以免除生命值的减少", 3)
            );
    public ObservableList<Product> getData() {
        return data;
    }
    public void setData(ObservableList<Product> data) {
        this.data = data;
    }
}
