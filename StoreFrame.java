package com.exercise.demo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

    public class StoreFrame extends Application {
        private Pane pane = new Pane();
        private TableView<Product> table = new TableView<>();
        private ObservableList<Product> data =
                FXCollections.observableArrayList(
                        new Product(1, "生命药剂", "恢复冒险者2点生命值", 2),
                        new Product(2, "暴击药剂", "如果冒险者购买后,下一关卡发生了战斗并获胜,可以让对手生命值减少3", 2),
                        new Product(3, "闪避符咒", "如果冒险者购买后,下一关卡发生了战斗并战败,可以免除生命值的减少", 3)
                );

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


        public void TableSet(){
            TableColumn<Product, Integer> indexCol = new TableColumn<Product, Integer>("Index");
            indexCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("index"));

            TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

            TableColumn<Product, String> workCol = new TableColumn<Product, String>("Work");
            workCol.setCellValueFactory(new PropertyValueFactory<Product, String>("work"));

            TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("Price");
            priceCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));

            table.setItems(data);
            table.getColumns().addAll(indexCol,nameCol, workCol,priceCol);
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
                Product product = table.getSelectionModel().getSelectedItem();
                System.out.println("商品名：" + product.getName() + "，价格：" + product.getPrice());

            });
        }
        public void TextSet(){
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

