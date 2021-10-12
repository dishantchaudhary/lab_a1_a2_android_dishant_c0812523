package com.example.lab_a1_a2_android_dishant_c0812523.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProviderDao {
    @Query("SELECT * FROM provider_table")
    LiveData<List<Provider>> getALlProviders();

    @Insert
    void insert(Provider provider);

    @Update
    void update(Provider provider);

    @Delete
    void delete(Provider provider);
}
