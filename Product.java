package com.exercise.demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private final SimpleIntegerProperty index;
    private final SimpleStringProperty name;
    private final SimpleStringProperty work;
    private final SimpleIntegerProperty price;

    public Product(int index, String name, String work, int price) {
        this.index = new SimpleIntegerProperty(index);
        this.name = new SimpleStringProperty(name);
        this.work = new SimpleStringProperty(work);
        this.price = new SimpleIntegerProperty(price);
    }

    public int getIndex() {
        return index.get();
    }

    public String getName() {
        return name.get();
    }

    public String getWork() {
        return work.get();
    }

    public int getPrice() {
        return price.get();
    }

}
