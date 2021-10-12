package com.example.lab_a1_a2_android_dishant_c0812523.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ProductDao {

    @Query("SELECT * FROM product_table")
    LiveData<List<Product>> getAllProducts();

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
