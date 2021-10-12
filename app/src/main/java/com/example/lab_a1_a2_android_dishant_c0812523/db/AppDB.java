package com.example.lab_a1_a2_android_dishant_c0812523.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class,Provider.class},version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCE;
    public abstract ProductDao productDao();
    public abstract ProviderDao providerDao();

    public static synchronized AppDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB.class,"app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
