package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitialFrame extends Application {
    private Level level;
    private String destination;
    private Pane pane = new Pane();

    //level的get方法
    public Level getLevel() {
        return level;
    }

    //level的set方法
    public void setLevel(Level level) {
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


    public void welcomeTextSet() {
        // 创建欢迎文本
        Text welcomeText1 = new Text("Welcome to the Game!You are a Hobbit. \n");
        welcomeText1.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        Text welcomeText2 = new Text("You have to defeat the enemies to win the game.\n");
        welcomeText2.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        Text welcomeText3 = new Text("If you win, you will get gold.\n");
        welcomeText3.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        Text welcomeText4 = new Text("If you lose, you will lose health.\n");
        welcomeText4.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        Text welcomeText5 = new Text("Let's start the game!\n");
        welcomeText5.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        // 设置每个欢迎文本的位置
        welcomeText1.relocate(250, 0);
        welcomeText2.relocate(235, 25);
        welcomeText3.relocate(290, 50);
        welcomeText4.relocate(280, 75);
        welcomeText5.relocate(305, 100);
        // 将欢迎文本添加到Pane中
        pane.getChildren().addAll(welcomeText1, welcomeText2, welcomeText3, welcomeText4, welcomeText5);

    }

    public void destinationSet() {
        //创建一个目的地输入框
        // 创建输入框
        TextField destinationField = new TextField();
        //设置输入框的大小
        destinationField.setPrefSize(200, 40);
        destinationField.setPromptText("Enter your destination：");
        //创建提交按钮
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String destination = destinationField.getText().trim();
            if (destination.isEmpty()) {
                // 如果输入为空，显示错误消息
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Destination cannot be empty. Please enter your destination.");
                alert.showAndWait();
            } else if (destination.length() < 4 || destination.length() > 16) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The length of the destination should be 4-16 characters.");
                alert.showAndWait();
            } else if (destination.charAt(0) == ' ' || destination.charAt(destination.length() - 1) == ' ') {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The destination should not start or end with a space.");
                alert.showAndWait();
            } else if (!destination.matches("^[a-zA-Z ]+$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The destination should only contain letters and spaces.");
                alert.showAndWait();
            } else {
                // 在这里处理用户的输入
                System.out.println("Destination: " + destination);
                setDestination(destination);
            }
        });
        // 设置输入框和提交按钮的位置
        destinationField.relocate(270, 200);
        submitButton.relocate(500, 200);
        // 将输入框和提交按钮添加到Pane中
        pane.getChildren().addAll(destinationField, submitButton);
    }

    public void levelSet() {
        //设计一个关卡输入框，用户输入关卡数
        // 创建输入框
        TextField levelField = new TextField();
        //设置输入框的大小
        levelField.setPrefSize(200, 40);
        levelField.setPromptText("Enter the level you want to play：");
        // 创建提交按钮
        Button submitButton2 = new Button("Submit");
        submitButton2.setOnAction(e -> {
            String level = levelField.getText().trim();
            if (level.isEmpty()) {
                // 如果输入为空，显示错误消息
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Level cannot be empty. Please enter the level you want to play.");
                alert.showAndWait();
            } else if (!level.matches("^[0-9]*$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The level should only contain numbers.");
                alert.showAndWait();
            } else if (Integer.parseInt(level) < 1 || Integer.parseInt(level) > 20) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The level should be between 1 and 20.");
                alert.showAndWait();
            } else {
                // 在这里处理用户的输入
                System.out.println("Level: " + level);
                Level level1 = new Level();
                level1.setAllLevel(Integer.parseInt(level));
                setLevel(level1);
            }
        });
        // 设置输入框和提交按钮的位置
        levelField.relocate(270, 300);
        submitButton2.relocate(500, 300);
        // 将输入框和提交按钮添加到Pane中
        pane.getChildren().addAll(levelField, submitButton2);
    }

    public void playGameSet(Stage primaryStage) {
        // 创建开始游戏按钮
        Button startButton = new Button("Start Game");
        //设计“start game”的字体
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        startButton.relocate(100, 450); // 设置按钮的位置
        //设置按钮的大小
        startButton.setPrefSize(150, 80);
        startButton.setOnAction(e -> {
            //如果此时level和destination都不为空，则进入游戏界面
            if (getLevel() != null && getDestination() != null) {
                // 在这里添加开始游戏的代码
                GameFrame gameFrame = new GameFrame();
                gameFrame.setLevel(getLevel());
                gameFrame.setDestination(getDestination());
                gameFrame.start(primaryStage);
                System.out.println("开始游戏");

            } else {
                // 如果level和destination为空，显示错误消息
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter the level and destination before starting the game.");
                alert.showAndWait();
            }
        });
        pane.getChildren().addAll(startButton);
    }

    public void endGameSet(Stage primaryStage) {
        // 创建结束游戏按钮
        Button endButton = new Button("End Game");
        //设计“end game”的字体
        endButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        endButton.relocate(500, 450); // 设置按钮的位置
        //设置按钮的大小
        endButton.setPrefSize(150, 80);
        endButton.setOnAction(e -> {
            // 在这里添加结束游戏的代码
            primaryStage.close();
        });
        //将按钮添加到Pane中
        pane.getChildren().addAll(endButton);
    }

    @Override
    public void start(Stage primaryStage) {
        welcomeTextSet();
        destinationSet();
        levelSet();
        playGameSet(primaryStage);
        endGameSet(primaryStage);
        // 创建一个Scene并设置Pane为其根节点
        Scene scene = new Scene(pane, 800, 600);
        // 设置并显示Stage
        primaryStage.setTitle("中世纪冒险游戏");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

