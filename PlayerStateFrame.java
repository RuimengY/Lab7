package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerStateFrame extends Application {
    private Creature player = new Creature();
    private Pane pane = new Pane();

    //player的get和set方法
    public Creature getPlayer() {
        return player;
    }

    public void setPlayer(Creature player) {
        this.player = player;
    }

    @Override
    public void start(Stage stage) {
        Heart(30, 50, player.getLife());
        Gold(10, 100, player.getGold());
        StoreButton();
        // 创建一个Scene并设置Pane为其根节点
        Scene scene = new Scene(pane, 400, 300);
        // 设置并显示Stage
        stage.setTitle("中世纪冒险游戏");
        stage.setScene(scene);
        stage.show();
    }

    //用爱心图形的数量表示生命值
    public void Heart(int x, int y, int life) {
        for (int i = 0; i < life; i++) {
            //爱心图形从Unicode中选取
            Text heart = new Text(x + i * 20, y, "❤");
            heart.setFont(Font.font(20));
            heart.setFill(Color.RED);
            pane.getChildren().add(heart);
        }
    }

    //用金币图像表示金币数量
    public void Gold(int x, int y, int gold) {
        for (int i = 0; i < gold; i++) {
            Text coin = new Text(x + i * 20, y, "💰");
            coin.setFont(Font.font(20));
            coin.setFill(Color.GOLD);
            pane.getChildren().add(coin);
        }
    }

    //道具的三个按钮(按钮分别是package中的生命药剂、暴击药剂和闪避符咒)
    public void StoreButton() {
        Text lifePotion = new Text(10, 70, "生命药剂");
        lifePotion.setFont(Font.font(20));
        lifePotion.setFill(Color.BLUE);
        pane.getChildren().add(lifePotion);
        Text crtPotion = new Text(10, 100, "暴击药剂");
        crtPotion.setFont(Font.font(20));
        crtPotion.setFill(Color.BLUE);
        pane.getChildren().add(crtPotion);
        Text dodgePotion = new Text(10, 130, "闪避符咒");
        dodgePotion.setFont(Font.font(20));
        dodgePotion.setFill(Color.BLUE);
        pane.getChildren().add(dodgePotion);
    }
}
