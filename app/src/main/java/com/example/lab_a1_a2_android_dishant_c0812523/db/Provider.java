package com.example.lab_a1_a2_android_dishant_c0812523.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "provider_table")
public class Provider {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "providerId")
    private int providerId;

    @ColumnInfo(name = "providerName")
    private String providerName;

    @ColumnInfo(name = "providerEmail")
    private String providerEmail;

    @ColumnInfo(name = "providerPhoneNo")
    private String providerPhoneNo;

    @ColumnInfo(name = "providerLatitude")
    private Double providerLatitude;

    @ColumnInfo(name = "proiderLongitude")
    private Double proiderLongitude;

    public Provider(String providerName, String providerEmail, String providerPhoneNo, Double providerLatitude, Double proiderLongitude) {
        this.providerName = providerName;
        this.providerEmail = providerEmail;
        this.providerPhoneNo = providerPhoneNo;
        this.providerLatitude = providerLatitude;
        this.proiderLongitude = proiderLongitude;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }

    public String getProviderPhoneNo() {
        return providerPhoneNo;
    }

    public void setProviderPhoneNo(String providerPhoneNo) {
        this.providerPhoneNo = providerPhoneNo;
    }

    public Double getProviderLatitude() {
        return providerLatitude;
    }

    public void setProviderLatitude(Double providerLatitude) {
        this.providerLatitude = providerLatitude;
    }

    public Double getProiderLongitude() {
        return proiderLongitude;
    }

    public void setProiderLongitude(Double proiderLongitude) {
        this.proiderLongitude = proiderLongitude;
    }
}
