package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StateFrame extends Application {

    @Override
    public void start(Stage stage) {
    }

    //用金币图像表示金币数量
    public void Gold(int x, int y, int length, Pane pane, Creature creature) {
        int realMoney2 = 0;
        int realMoney1 = 0;
        int fakeMoney2 = 0;
        int fakeMoney1 = 0;
        for (int i = 0; i < length; i++) {
            if (creature.getMoney()[i] == null) {
                continue;
            } else if (creature.getMoney()[i].getRealCoin() && creature.getMoney()[i].getValue() == 2) {
                realMoney2++;
            } else if (creature.getMoney()[i].getRealCoin() && creature.getMoney()[i].getValue() == 1) {
                realMoney1++;
            } else if (!creature.getMoney()[i].getRealCoin() && creature.getMoney()[i].getValue() == 2) {
                fakeMoney2++;
            } else if (!creature.getMoney()[i].getRealCoin() && creature.getMoney()[i].getValue() == 1) {
                fakeMoney1++;
            }
            if ((realMoney1 + realMoney2) >= (fakeMoney1 + fakeMoney2)) {
                realMoneyImage2(x, y, realMoney2, pane);
                realMoneyImage1(x, y + 20, realMoney1, pane);
                fakeMoneyImage2(x, y + 40, fakeMoney2, pane);
                fakeMoneyImage1(x, y + 60, fakeMoney1, pane);
            } else {
                fakeMoneyImage2(x, y, fakeMoney2, pane);
                fakeMoneyImage1(x, y + 20, fakeMoney1, pane);
                realMoneyImage2(x, y + 40, realMoney2, pane);
                realMoneyImage1(x, y + 60, realMoney1, pane);
            }
        }
    }

    public void realMoneyImage2(int x, int y, int realMoney2, Pane pane) {
        for (int i = 0; i < realMoney2; i++) {
            Image coin = new Image("file:photos/coin.png");
            // CoinBothSet(x, y, pane, creature, i, coin);
            ImageView imageView = new ImageView(coin);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            imageView.setX(x + i * 20);
            imageView.setY(y);
            pane.getChildren().add(imageView);
        }
    }

    public void realMoneyImage1(int x, int y, int realMoney1, Pane pane) {
        for (int i = 0; i < realMoney1; i++) {
            Image coin = new Image("file:photos/coin.png");
            // CoinBothSet(x, y, pane, creature, i, coin);
            ImageView imageView = new ImageView(coin);
            imageView.setFitHeight(15);
            imageView.setFitWidth(15);
            imageView.setX(x + i * 20);
            imageView.setY(y);
            pane.getChildren().add(imageView);
        }
    }

    public void fakeMoneyImage2(int x, int y, int fakeMoney2, Pane pane) {
        for (int i = 0; i < fakeMoney2; i++) {
            Image coin = new Image("file:photos/falseCoin.png");
            // CoinBothSet(x, y, pane, creature, i, coin);
            ImageView imageView = new ImageView(coin);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            imageView.setX(x + i * 20);
            imageView.setY(y);
            pane.getChildren().add(imageView);
        }
    }


    public void fakeMoneyImage1(int x, int y, int fakeMoney1, Pane pane) {
        for (int i = 0; i < fakeMoney1; i++) {
            Image coin = new Image("file:photos/falseCoin.png");
            // CoinBothSet(x, y, pane, creature, i, coin);
            ImageView imageView = new ImageView(coin);
            imageView.setFitHeight(15);
            imageView.setFitWidth(15);
            imageView.setX(x + i * 20);
            imageView.setY(y);
            pane.getChildren().add(imageView);
        }
    }


}

