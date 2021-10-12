package com.example.lab_a1_a2_android_dishant_c0812523.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class Product {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "productId")
        private int productId;

        @ColumnInfo(name = "productName")
        private String productName;

        @ColumnInfo(name = "productDescription")
        private String productDescription;

        @ColumnInfo(name = "productPrice")
        private Double productPrice;

        @ColumnInfo(name = "productProvider")
        private String productProvider;

    public Product(String productName, String productDescription, Double productPrice, String productProvider) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productProvider = productProvider;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductProvider() {
        return productProvider;
    }

    public void setProductProvider(String productProvider) {
        this.productProvider = productProvider;
    }
}
