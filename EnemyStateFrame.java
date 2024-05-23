package com.exercise.demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EnemyStateFrame extends Application{
    private Creature enemy = Creature.randomEnemy();
    private Pane pane = new Pane();

    //enemy的get和set方法
    public Creature getEnemy() {
        return enemy;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    @Override
    public void start(Stage stage) {
        Heart(30, 50, enemy.getLife());
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
            heart.setFill(Color.GRAY);
            pane.getChildren().add(heart);
        }
    }


}
