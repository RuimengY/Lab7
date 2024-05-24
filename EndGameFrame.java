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
    private Creature player;
    private Creature enemy;
    private Package myPackage;

    public void setPlayer(Creature player) {
        this.player = player;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    public void setMyPackage(Package myPackage) {
        this.myPackage = myPackage;
    }

    Pane pane = new Pane();

    @Override
    public void start(Stage stage) {
        gameResultTextSet("Game Over!");
        GameScoreTextSet();
        gameOverButton();
        PlayerStateButton();
        EnemyButton();
        // PlayerFinalState();
        // EnemyFinalState();
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
        gameResultText.relocate(350, 50);
        // 将游戏结果文本添加到Pane中
        pane.getChildren().add(gameResultText);
    }

    public void GameScoreTextSet() {
        Text winnerText = new Text("Winner: " + enemy.getName());
        winnerText.setFont(Font.font("Arial", FontWeight.NORMAL, 25));
        winnerText.relocate(300, 150);
        if (player.getLife() == 0) {
            System.out.println("Winner: " + enemy.getName());

        } else if (enemy.getLife() == 0) {
            System.out.println("Winner: " + player.getName());
            winnerText.setText("Winner: " + player.getName());
        } else {
            System.out.println("Winner: " + enemy.getName() + " and " + player.getName());
            winnerText.setText("Winner: " + enemy.getName() + " and " + player.getName());
            winnerText.relocate(250, 150);
        }

        // 创建游戏得分文本
        Text gameScoreText = new Text("Your score: " + (int) (player.getGold() * 100.0 / (player.getGold() + enemy.getGold())) + "%");
        gameScoreText.setFont(Font.font("Arial", FontWeight.NORMAL, 25));
        // 设置游戏得分文本的位置
        gameScoreText.relocate(300, 250);
        // 将游戏得分文本添加到Pane中
        pane.getChildren().addAll(gameScoreText, winnerText);
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

    public void PlayerStateButton() {
        //创建一个“查看角色状态”按钮
        Button playerStateButton = new Button("玩家最终状态");
        //设计按钮的字体
        playerStateButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        playerStateButton.relocate(10, 350);
        //设置按钮的大小
        playerStateButton.setPrefSize(250, 100);
        //在这里添加将playerStateButton添加到界面的代码
        pane.getChildren().add(playerStateButton);
        //点击按钮弹出一个新的界面
        playerStateButton.setOnAction(e -> {
            PlayerStateFrame playerStateFrame = new PlayerStateFrame();
            playerStateFrame.setPlayer(player);
            playerStateFrame.setPackage(myPackage);
            playerStateFrame.start(new Stage());
        });
    }

    public void EnemyButton() {
        //创建一个“查看敌人状态”按钮
        Button enermyButton = new Button("敌人最终状态");
        //设计按钮的字体
        enermyButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        enermyButton.relocate(500, 350);
        //设置按钮的大小
        enermyButton.setPrefSize(250, 100);
        //在这里添加将playerStateButton添加到界面的代码
        pane.getChildren().add(enermyButton);
        //点击按钮弹出一个新的界面
        enermyButton.setOnAction(e -> {
            EnemyStateFrame enemyStateFrame = new EnemyStateFrame();
            enemyStateFrame.setEnemy(enemy);
            enemyStateFrame.start(new Stage());
        });
    }
}
