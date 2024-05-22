package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameFrame extends Application {
    private int level;
    private String destination;
    private Pane pane = new Pane();


    // private Text levelText;
    //level的get方法
    public int getLevel() {
        return level;
    }

    //level的set方法
    public void setLevel(int level) {
        this.level = level;
    }

    //destination的get方法
    public String getDestination() {
        return destination;
    }

    //destination的set方法
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void start(Stage stage) {
        //for (int i = 1; i <= level; i++) {
        LevelText(1);
        StoreButton();
        // }

        stage.setScene(new Scene(pane, 800, 600));
        stage.show();

    }

    public void LevelText(int everyLevel) {
        // 创建一个文本框显示关卡数(level)，如果是奖励关卡，显示“[奖励关卡]”
        Text levelText = new Text();
        if (everyLevel % 3 == 0) {
            levelText.setText("[奖励关卡]");
        } else {
            levelText.setText("Level: " + (level + 1));
        }
        //设置levelText的位置
        levelText.relocate(350, 70);
        //设置输出字体和显示边框

        levelText.setStyle("-fx-font-size: 20");
        // 在这里添加将levelText添加到界面的代码
        pane.getChildren().add(levelText);
    }

    public void StoreButton() {
        //创建一个“查看商店”按钮
        Button storeButton = new Button("查看商店");
        //设置按钮的位置
        storeButton.relocate(340, 120);
        //设置按钮的大小
        storeButton.setPrefSize(100, 30);
        //在这里添加将storeButton添加到界面的代码
        pane.getChildren().add(storeButton);
        //点击按钮弹出一个新的界面
        storeButton.setOnAction(e -> {
            StoreFrame storeFrame = new StoreFrame();
            storeFrame.start(new Stage());
        });
    }
}

