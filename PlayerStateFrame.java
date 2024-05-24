package com.exercise.demo;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class PlayerStateFrame extends StateFrame {
    private Creature player = new Creature();
    private Pane pane = new Pane();
    private Package pack;

    //player的get和set方法
    public Creature getPlayer() {
        return player;
    }

    public void setPlayer(Creature player) {
        this.player = player;
    }

    public Package getPack() {
        return pack;
    }

    public void setPackage(Package pack) {
        this.pack = pack;
    }

    @Override
    public void start(Stage stage) {
        Heart(30, 50, player.getLife());
        Gold(30, 100, player.getMoney().length, pane, player);
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

    //道具的三个按钮(按钮分别是package中的生命药剂、暴击药剂和闪避符咒)
    public void StoreButton() {
        Button lifePotion = new Button("生命药剂");
        Button crtPotion = new Button("暴击药剂");
        Button dodgePotion = new Button("闪避符咒");

        lifePotion.setLayoutX(30);
        lifePotion.setLayoutY(250);
        lifePotion.setFont(Font.font(20));
        if (pack.getSkill(0) == 0) {
            //不显示生命药剂
            lifePotion.setVisible(false);
        }
        lifePotion.setOnMouseClicked(event -> {
            //如果点击生命药剂，弹出是否要使用的对话框
            //创建一个新的窗口确定是否使用
            // 创建一个确认对话框
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Confirmation Dialog");
            alert1.setHeaderText("Usage Confirmation");
            alert1.setContentText("Are you sure you want to use this item?");

            // 显示对话框，并等待用户响应
            Optional<ButtonType> result = alert1.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // 用户点击了确认按钮，执行购买操作
                // 这里的purchase()方法是你的购买操作，你需要根据你的实际情况来实现这个方法
                System.out.println("确定下一关使用第一个道具");
                System.out.println("原来:" + player.getLife());
                pack.usageOfTools(player, 0);
                System.out.println("skill[0]: " + player.getSkill()[0]);
                lifePotion.setDisable(true);
                crtPotion.setDisable(true);
                dodgePotion.setDisable(true);

            }
        });

        pane.getChildren().add(lifePotion);


        crtPotion.setLayoutX(150);
        crtPotion.setLayoutY(250);
        crtPotion.setFont(Font.font(20));
        if (pack.getSkill(1) == 0) {
            //不显示暴击药剂
            crtPotion.setVisible(false);
        }
        crtPotion.setOnMouseClicked(event -> {
            //创建一个新的窗口确定是否使用
            // 创建一个确认对话框
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Confirmation Dialog");
            alert2.setHeaderText("Usage Confirmation");
            alert2.setContentText("Are you sure you want to use this item?");

            // 显示对话框，并等待用户响应
            Optional<ButtonType> result2 = alert2.showAndWait();
            if (result2.isPresent() && result2.get() == ButtonType.OK) {
                // 用户点击了确认按钮，执行购买操作
                // 这里的purchase()方法是你的购买操作，你需要根据你的实际情况来实现这个方法
                System.out.println("确定下一关使用第二个道具");
                pack.usageOfTools(player, 1);
                System.out.println("skill[1]: " + player.getSkill()[1]);
                lifePotion.setDisable(true);
                crtPotion.setDisable(true);
                dodgePotion.setDisable(true);

            }
        });

        pane.getChildren().add(crtPotion);


        dodgePotion.setLayoutX(270);
        dodgePotion.setLayoutY(250);
        dodgePotion.setFont(Font.font(20));
        if (pack.getSkill(2) == 0) {
            //不显示闪避符咒
            dodgePotion.setVisible(false);
        }
        dodgePotion.setOnMouseClicked(event -> {
            //创建一个新的窗口确定是否使用
            // 创建一个确认对话框
            Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
            alert3.setTitle("Confirmation Dialog");
            alert3.setHeaderText("Usage Confirmation");
            alert3.setContentText("Are you sure you want to use this item?");

            // 显示对话框，并等待用户响应
            Optional<ButtonType> result3 = alert3.showAndWait();
            if (result3.isPresent() && result3.get() == ButtonType.OK) {
                // 用户点击了确认按钮，执行购买操作
                // 这里的purchase()方法是你的购买操作，你需要根据你的实际情况来实现这个方法
                System.out.println("确定下一关使用第三个道具");

                pack.usageOfTools(player, 2);
                System.out.println("skill[2]: " + player.getSkill()[2]);

                lifePotion.setDisable(true);
                crtPotion.setDisable(true);
                dodgePotion.setDisable(true);

            }
        });

        pane.getChildren().add(dodgePotion);
    }
}
