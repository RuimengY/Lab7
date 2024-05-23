package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndGameFrame extends Application {
    Pane pane = new Pane();
    @Override
    public void start(Stage stage) {
        gameResultTextSet("Game Over!");
        GameScoreTextSet(0);
        gameOverButton();
        PlayerFinalState();
        EnemyFinalState();
        // 创建一个Scene并设置Pane为其根节点
        Scene scene = new Scene(pane, 800, 600);
        // 设置并显示Stage
        stage.setTitle("中世纪冒险游戏");
        stage.setScene(scene);
        stage.show();
    }
    public void gameResultTextSet(String result) {
        // 创建游戏结果文本
        Text gameResultText = new Text(result);
        gameResultText.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        // 设置游戏结果文本的位置
        gameResultText.relocate(350, 100);
        // 将游戏结果文本添加到Pane中
        pane.getChildren().add(gameResultText);
    }
    public void GameScoreTextSet(int score) {
        // 创建游戏得分文本
        Text gameScoreText = new Text("Your score is: " + score);
        gameScoreText.setFont(Font.font("Arial", FontWeight.NORMAL, 25));
        // 设置游戏得分文本的位置
        gameScoreText.relocate(300, 250);
        // 将游戏得分文本添加到Pane中
        pane.getChildren().add(gameScoreText);
    }
    public void gameOverButton() {
        // 创建游戏结束按钮
        Button gameOverButton = new Button("退出游戏");
        gameOverButton.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        //设置按钮大小
        gameOverButton.setPrefSize(200, 50);
        // 设置游戏结束按钮的点击事件
        gameOverButton.setOnAction(e -> {
            System.exit(0);
        });
        // 设置游戏结束按钮的位置
        gameOverButton.relocate(300, 500);
        // 将游戏结束按钮添加到Pane中
        pane.getChildren().add(gameOverButton);
    }
    public void PlayerFinalState() {
        // 创建玩家最终状态文本
        Text playerFinalState = new Text("Player Final State");
        playerFinalState.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        // 设置玩家最终状态文本的位置
        playerFinalState.relocate(100, 250);
        // 将玩家最终状态文本添加到Pane中
        pane.getChildren().add(playerFinalState);
    }
    public void EnemyFinalState() {
        // 创建敌人最终状态文本
        Text enemyFinalState = new Text("Enemy Final State");
        enemyFinalState.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        // 设置敌人最终状态文本的位置
        enemyFinalState.relocate(500, 250);
        // 将敌人最终状态文本添加到Pane中
        pane.getChildren().add(enemyFinalState);
    }
}
