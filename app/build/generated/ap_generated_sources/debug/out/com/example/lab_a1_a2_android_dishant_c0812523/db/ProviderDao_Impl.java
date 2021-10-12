package com.example.lab_a1_a2_android_dishant_c0812523.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProviderDao_Impl implements ProviderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Provider> __insertionAdapterOfProvider;

  private final EntityDeletionOrUpdateAdapter<Provider> __deletionAdapterOfProvider;

  private final EntityDeletionOrUpdateAdapter<Provider> __updateAdapterOfProvider;

  public ProviderDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProvider = new EntityInsertionAdapter<Provider>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `provider_table` (`providerId`,`providerName`,`providerEmail`,`providerPhoneNo`,`providerLatitude`,`proiderLongitude`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Provider value) {
        stmt.bindLong(1, value.getProviderId());
        if (value.getProviderName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProviderName());
        }
        if (value.getProviderEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProviderEmail());
        }
        if (value.getProviderPhoneNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProviderPhoneNo());
        }
        if (value.getProviderLatitude() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getProviderLatitude());
        }
        if (value.getProiderLongitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getProiderLongitude());
        }
      }
    };
    this.__deletionAdapterOfProvider = new EntityDeletionOrUpdateAdapter<Provider>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `provider_table` WHERE `providerId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Provider value) {
        stmt.bindLong(1, value.getProviderId());
      }
    };
    this.__updateAdapterOfProvider = new EntityDeletionOrUpdateAdapter<Provider>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `provider_table` SET `providerId` = ?,`providerName` = ?,`providerEmail` = ?,`providerPhoneNo` = ?,`providerLatitude` = ?,`proiderLongitude` = ? WHERE `providerId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Provider value) {
        stmt.bindLong(1, value.getProviderId());
        if (value.getProviderName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProviderName());
        }
        if (value.getProviderEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProviderEmail());
        }
        if (value.getProviderPhoneNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProviderPhoneNo());
        }
        if (value.getProviderLatitude() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getProviderLatitude());
        }
        if (value.getProiderLongitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getProiderLongitude());
        }
        stmt.bindLong(7, value.getProviderId());
      }
    };
  }

  @Override
  public void insert(final Provider provider) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProvider.insert(provider);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Provider provider) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProvider.handle(provider);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Provider provider) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProvider.handle(provider);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Provider>> getALlProviders() {
    final String _sql = "SELECT * FROM provider_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"provider_table"}, false, new Callable<List<Provider>>() {
      @Override
      public List<Provider> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProviderId = CursorUtil.getColumnIndexOrThrow(_cursor, "providerId");
          final int _cursorIndexOfProviderName = CursorUtil.getColumnIndexOrThrow(_cursor, "providerName");
          final int _cursorIndexOfProviderEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "providerEmail");
          final int _cursorIndexOfProviderPhoneNo = CursorUtil.getColumnIndexOrThrow(_cursor, "providerPhoneNo");
          final int _cursorIndexOfProviderLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "providerLatitude");
          final int _cursorIndexOfProiderLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "proiderLongitude");
          final List<Provider> _result = new ArrayList<Provider>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Provider _item;
            final String _tmpProviderName;
            if (_cursor.isNull(_cursorIndexOfProviderName)) {
              _tmpProviderName = null;
            } else {
              _tmpProviderName = _cursor.getString(_cursorIndexOfProviderName);
            }
            final String _tmpProviderEmail;
            if (_cursor.isNull(_cursorIndexOfProviderEmail)) {
              _tmpProviderEmail = null;
            } else {
              _tmpProviderEmail = _cursor.getString(_cursorIndexOfProviderEmail);
            }
            final String _tmpProviderPhoneNo;
            if (_cursor.isNull(_cursorIndexOfProviderPhoneNo)) {
              _tmpProviderPhoneNo = null;
            } else {
              _tmpProviderPhoneNo = _cursor.getString(_cursorIndexOfProviderPhoneNo);
            }
            final Double _tmpProviderLatitude;
            if (_cursor.isNull(_cursorIndexOfProviderLatitude)) {
              _tmpProviderLatitude = null;
            } else {
              _tmpProviderLatitude = _cursor.getDouble(_cursorIndexOfProviderLatitude);
            }
            final Double _tmpProiderLongitude;
            if (_cursor.isNull(_cursorIndexOfProiderLongitude)) {
              _tmpProiderLongitude = null;
            } else {
              _tmpProiderLongitude = _cursor.getDouble(_cursorIndexOfProiderLongitude);
            }
            _item = new Provider(_tmpProviderName,_tmpProviderEmail,_tmpProviderPhoneNo,_tmpProviderLatitude,_tmpProiderLongitude);
            final int _tmpProviderId;
            _tmpProviderId = _cursor.getInt(_cursorIndexOfProviderId);
            _item.setProviderId(_tmpProviderId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
