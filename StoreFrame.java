package com.exercise.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class StoreFrame extends Application {
    private Pane pane = new Pane();
    private TableView<Product> table = new TableView<>();
    private NewProductList newProductList;
    private Package myPackage;
    private Creature player;

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

    public NewProductList getNewProductList() {
        return newProductList;
    }

    public void setNewProductList(NewProductList newProductList) {
        this.newProductList = newProductList;
    }

    @Override
    public void start(Stage primaryStage) {
        TableSet();
        TextSet();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("商店商品");
        primaryStage.setScene(scene);
        //设置页面大小
        primaryStage.setWidth(600);
        primaryStage.setHeight(200);
        primaryStage.show();
    }


    public void TableSet() {
        TableColumn<Product, Integer> indexCol = new TableColumn<Product, Integer>("Index");
        indexCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("index"));

        TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, String> workCol = new TableColumn<Product, String>("Work");
        workCol.setCellValueFactory(new PropertyValueFactory<Product, String>("work"));

        TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        //data的内容已经经过remove()了
        table.setItems(newProductList.getData());
        table.getColumns().addAll(indexCol, nameCol, workCol, priceCol);
        //设置表格内字体的大小
        table.setStyle("-fx-font-size: 13");
        //设置表格的大小
        table.setPrefSize(600, 200);
        //设置表格的位置
        table.relocate(0, 50);
        //将表格添加到pane中
        pane.getChildren().addAll(table);
        //如果点击表格的某一行，会购买该物品
        table.setOnMouseClicked(event -> {
            //创建一个新的窗口确定是否购买
            // 创建一个确认对话框
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Purchase Confirmation");
            alert.setContentText("Are you sure you want to purchase this item?");

            // 显示对话框，并等待用户响应
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // 用户点击了确认按钮，执行购买操作
                // 这里的purchase()方法是你的购买操作，你需要根据你的实际情况来实现这个方法
                System.out.println("确认购买");
                Product product = table.getSelectionModel().getSelectedItem();
                System.out.println("商品名：" + product.getName() + "，价格：" + product.getPrice());
                newProductList.purchase(product, myPackage, player);
                //table只能被点击一次
                table.setDisable(true);
            }
        });
    }

    public void TextSet() {
        // 创建一个文本框显示商店商品
        Text storeText = new Text("商店商品");
        //设置storeText的位置
        storeText.relocate(250, 10);
        //设置输出字体和显示边框
        storeText.setStyle("-fx-font-size: 20");
        // 在这里添加将storeText添加到界面的代码
        pane.getChildren().add(storeText);
    }
}

