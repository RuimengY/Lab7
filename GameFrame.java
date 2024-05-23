package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameFrame extends Application {
    private String destination;
    private Pane pane = new Pane();
    private Package myPackage;
    private Creature player;
    private Creature enemy;
    private Level level;
    private Money[] money;
    private Button nextLevelButton = new Button("下一关");
    private NewProductList newProductList;


    public void setMoney(Money[] moneys) {
        this.money = moneys;
    }

    public void setNewProductList(NewProductList newProductList) {
        this.newProductList = newProductList;
    }


    // private Text levelText;
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

    public Money getOneMoney(Money[] moneyList, int levelNow) {
        return moneyList[levelNow - 1];
    }

    //package的get方法
    public Package getMyPackage() {
        return myPackage;
    }

    public void setMyPackage(Package myPackage) {
        this.myPackage = myPackage;
    }

    //player的get方法
    public Creature getPlayer() {
        return player;
    }

    public void setPlayer(Creature player) {
        this.player = player;
    }

    public void setEnemy(Creature enemy) {
        this.enemy = enemy;
    }

    @Override
    public void start(Stage stage) {
        int levelNow = level.levelNow();
        nextLevelButton.setDisable(true);
        System.out.println("levelNow: " + levelNow);
        System.out.println("level: " + level.getLevel());
        if (levelNow == level.getLevel() + 1) {
            EndGameFrame endGameFrame = new EndGameFrame();
            endGameFrame.start(stage);
        } else {
            StoreButton();
            PlayerStateButton();
            EnemyButton();
            PlayerImage();
            EnemyImage();
            DestinationText();
            LevelText(levelNow);
            FightButton(levelNow);
            BoxOrCoinImage(levelNow);
            NextLevelButton(stage, levelNow);
            stage.setScene(new Scene(pane, 800, 600));
            stage.show();
        }

    }

    public void LevelText(int everyLevel) {
        // 创建一个文本框显示关卡数(level)，如果是奖励关卡，显示“[奖励关卡]”
        Text levelText = new Text();
        if (everyLevel % 3 == 0) {
            levelText.setText("[奖励关卡]");
        } else {
            levelText.setText("Level: " + everyLevel);
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
            System.out.println("newProductList: " + newProductList.getData());
            storeFrame.setNewProductList(newProductList);

            storeFrame.setMyPackage(myPackage);
            //System.out.println("package "+ myPackage.getSkill(0));
            storeFrame.setPlayer(player);
            storeFrame.start(new Stage());
        });
    }

    public void PlayerStateButton() {
        //创建一个“查看角色状态”按钮
        Button playerStateButton = new Button("查看角色状态");
        //设计按钮的字体
        playerStateButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        playerStateButton.relocate(10, 50);
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
        Button enermyButton = new Button("查看敌人状态");
        //设计按钮的字体
        enermyButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        enermyButton.relocate(500, 50);
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

    public void PlayerImage() {
        //输出玩家的图像
        Image playerImage = new Image("file:photos/player.png");
        //创建一个ImageView对象
        ImageView playerImageView = new ImageView(playerImage);
        //设置玩家图像的位置
        playerImageView.relocate(50, 200);
        //在这里添加将playerImage添加到界面的代码
        pane.getChildren().add(playerImageView);

    }

    public void EnemyImage() {
        Image enemyImage;
        //输出敌人的图像
        if (enemy instanceof Elf) {
            enemyImage = new Image("file:photos/elf.png");
        } else if (enemy instanceof Dwarf) {
            enemyImage = new Image("file:photos/dwarf.png");
        } else enemyImage = new Image("file:photos/orc.png");
        //创建一个ImageView对象
        ImageView enemyImageView = new ImageView(enemyImage);
        //设置敌人图像的位置
        enemyImageView.relocate(550, 200);
        //在这里添加将enemyImage添加到界面的代码
        pane.getChildren().add(enemyImageView);
    }

    public void FightButton(int level1) {
        //创建一个“战斗”按钮
        Button fightButton = new Button("开始战斗");
        //如果是奖励关卡，FightButton不可点击
        if (level1 % 3 == 0) {
            fightButton.setDisable(true);
            //新建一个窗体显示战斗结果
            AwardFrame awardFrame = new AwardFrame();
            awardFrame.setPlayer(player);
            awardFrame.setEnemy(enemy);
            awardFrame.setLevelNow(level1);
            awardFrame.start(new Stage());
        }
        //设置按钮字体
        fightButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        fightButton.relocate(70, 450);
        //设置按钮的大小
        fightButton.setPrefSize(150, 60);
        //在这里添加将fightButton添加到界面的代码
        pane.getChildren().add(fightButton);
        //点击按钮弹出一个新的界面
        fightButton.setOnAction(e -> {
            System.out.println("开始战斗");
            //新建一个窗体显示战斗结果
            FightFrame fightFrame = new FightFrame();
            fightFrame.setPlayer(player);
            fightFrame.setEnemy(enemy);
            fightFrame.setMoney(money);
            fightFrame.setLevel(level);
            fightFrame.setLevelNow(level1);
            fightFrame.start(new Stage());
            nextLevelButton.setDisable(false);//能够点下一关
            //每关只能战斗一次
            fightButton.setDisable(true);
            RealCoinImage(level1);//展示真正的金币
        });
    }

    public void NextLevelButton(Stage stage, int levelNow) {
        //设置按钮字体
        nextLevelButton.setStyle("-fx-font-size: 20");
        //设置按钮的位置
        nextLevelButton.relocate(550, 450);
        //设置按钮的大小
        nextLevelButton.setPrefSize(150, 60);
        //只有在战斗结束后(FightButton被按下之后或者是奖励关卡)才会显示这个按钮
        if (levelNow % 3 == 0) {
            nextLevelButton.setDisable(false);
        } else {
            nextLevelButton.setDisable(true);
        }
        //在这里添加将nextLevelButton添加到界面的代码
        pane.getChildren().add(nextLevelButton);
        //点击按钮弹出一个新的界面
        nextLevelButton.setOnAction(e -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setLevel(level);
            gameFrame.setMoney(money);
            gameFrame.setPlayer(player);
            gameFrame.setEnemy(enemy);
            gameFrame.setDestination(destination);
            gameFrame.setNewProductList(newProductList);
            gameFrame.setMyPackage(myPackage);
            gameFrame.start(stage);
        });
    }

    public void DestinationText() {
        // 创建一个文本框显示目的地(destination)
        Text destinationText = new Text("Destination: " + destination);
        //设置destinationText的位置
        destinationText.relocate(330, 500);
        //设置输出字体和显示边框
        destinationText.setStyle("-fx-font-size: 20");
        // 在这里添加将destinationText添加到界面的代码
        pane.getChildren().add(destinationText);
    }

    public void BoxOrCoinImage(int level1) {
        if (level1 % 3 == 0) {
            //输出箱子的图像
            Image boxImage = new Image("file:photos/box.png");
            //创建一个ImageView对象
            ImageView boxImageView = new ImageView(boxImage);
            //设置箱子图像的位置
            boxImageView.relocate(300, 200);
            //在这里添加将boxImage添加到界面的代码
            pane.getChildren().add(boxImageView);
        } else {
            //输出金币的图像
            Image coinImage = new Image("file:photos/coin.png");
            //创建一个ImageView对象
            ImageView coinImageView = new ImageView(coinImage);
            //设置金币图像的位置
            coinImageView.relocate(300, 200);
            //在这里添加将coinImage添加到界面的代码
            pane.getChildren().add(coinImageView);
        }
    }

    public void RealCoinImage(int level) {
        Money oneMoney = getOneMoney(money, level);
        if (oneMoney.getRealCoin()) {
            //输出金币的图像
            Image coinImage = new Image("file:photos/coin.png");
            //创建一个ImageView对象
            ImageView coinImageView = new ImageView(coinImage);
            //设置金币图像的位置
            coinImageView.relocate(300, 200);
            //在这里添加将coinImage添加到界面的代码
            pane.getChildren().add(coinImageView);
        } else {
            //输出箱子的图像
            Image boxImage = new Image("file:photos/falseCoin.png");
            //创建一个ImageView对象
            ImageView boxImageView = new ImageView(boxImage);
            //设置箱子图像的位置
            boxImageView.relocate(300, 200);
            //在这里添加将boxImage添加到界面的代码
            pane.getChildren().add(boxImageView);
        }

    }

}

