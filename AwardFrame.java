package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AwardFrame extends Application {
    private Pane pane = new Pane();
    private Creature player;
    private Creature enemy;
    public void setPlayer(Creature player) {
        this.player = player;
    }
    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }
    @Override
    public void start(Stage stage)  {
        CoinText();
        player.setGold(player.getGold()+2);
        enemy.setGold(enemy.getGold()+2);
        // 创建一个Scene并设置Pane为其根节点
        Scene scene = new Scene(pane, 400, 300);
        // 设置并显示Stage
        stage.setTitle("奖励关卡结果");
        stage.setScene(scene);
        stage.show();
    }
    public void CoinText(){
        Text text = new Text(80, 100, "恭喜双方获得了金币奖励！");
        Text text2 = new Text(50, 150, "金币为真，数量均为1，面额为2");
        text.setFont(Font.font(20));
        text2.setFont(Font.font(20));
        text.setFill(Color.GRAY);
        text2.setFill(Color.GRAY);
        pane.getChildren().addAll(text, text2);
    }

}
