package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FightFrame extends Application{
    private Pane pane = new Pane();
    private Creature player;
    private Creature enemy;
    private Money[] money;
    private Level level;
    private int levelNow;
    public Creature getPlayer() {
        return player;
    }
    public void setPlayer(Creature player) {
        this.player = player;
    }
    public Creature getEnemy() {
        return enemy;
    }
    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }
    public Money[] getMoney() {
        return money;
    }
    public void setMoney(Money[] money) {
        this.money = money;
    }
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public int getLevelNow() {
        return levelNow;
    }
    public void setLevelNow(int levelNow) {
        this.levelNow = levelNow;
    }
    @Override
    public void start(Stage stage)  {
        level.everyLevel(player,enemy,money,levelNow);
        winnerText();
        CoinText();
        // 创建一个Scene并设置Pane为其根节点
        Scene scene = new Scene(pane, 400, 300);
        // 设置并显示Stage
        stage.setTitle("战斗结果");
        stage.setScene(scene);
        stage.show();
    }
    public void winnerText(){
        Text winnerText = new Text("win!");
        winnerText.setFont(Font.font("Arial", 20));
        winnerText.relocate(180, 80);
        pane.getChildren().add(winnerText);
    }
    public void CoinText(){
        Text coinText = new Text("You get 10 coins!");
        coinText.setFont(Font.font("Arial", 20));
        coinText.relocate(120, 200);
        pane.getChildren().add(coinText);
    }
}
