package com.example.lab_a1_a2_android_dishant_c0812523.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDB_Impl extends AppDB {
  private volatile ProductDao _productDao;

  private volatile ProviderDao _providerDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `product_table` (`productId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productName` TEXT, `productDescription` TEXT, `productPrice` REAL, `productProvider` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `provider_table` (`providerId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `providerName` TEXT, `providerEmail` TEXT, `providerPhoneNo` TEXT, `providerLatitude` REAL, `proiderLongitude` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bcce1beda009f31a1aaaa5f1b111b461')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `product_table`");
        _db.execSQL("DROP TABLE IF EXISTS `provider_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProductTable = new HashMap<String, TableInfo.Column>(5);
        _columnsProductTable.put("productId", new TableInfo.Column("productId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("productName", new TableInfo.Column("productName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("productDescription", new TableInfo.Column("productDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("productPrice", new TableInfo.Column("productPrice", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductTable.put("productProvider", new TableInfo.Column("productProvider", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductTable = new TableInfo("product_table", _columnsProductTable, _foreignKeysProductTable, _indicesProductTable);
        final TableInfo _existingProductTable = TableInfo.read(_db, "product_table");
        if (! _infoProductTable.equals(_existingProductTable)) {
          return new RoomOpenHelper.ValidationResult(false, "product_table(com.example.lab_a1_a2_android_dishant_c0812523.db.Product).\n"
                  + " Expected:\n" + _infoProductTable + "\n"
                  + " Found:\n" + _existingProductTable);
        }
        final HashMap<String, TableInfo.Column> _columnsProviderTable = new HashMap<String, TableInfo.Column>(6);
        _columnsProviderTable.put("providerId", new TableInfo.Column("providerId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProviderTable.put("providerName", new TableInfo.Column("providerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProviderTable.put("providerEmail", new TableInfo.Column("providerEmail", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProviderTable.put("providerPhoneNo", new TableInfo.Column("providerPhoneNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProviderTable.put("providerLatitude", new TableInfo.Column("providerLatitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProviderTable.put("proiderLongitude", new TableInfo.Column("proiderLongitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProviderTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProviderTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProviderTable = new TableInfo("provider_table", _columnsProviderTable, _foreignKeysProviderTable, _indicesProviderTable);
        final TableInfo _existingProviderTable = TableInfo.read(_db, "provider_table");
        if (! _infoProviderTable.equals(_existingProviderTable)) {
          return new RoomOpenHelper.ValidationResult(false, "provider_table(com.example.lab_a1_a2_android_dishant_c0812523.db.Provider).\n"
                  + " Expected:\n" + _infoProviderTable + "\n"
                  + " Found:\n" + _existingProviderTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bcce1beda009f31a1aaaa5f1b111b461", "d996eafc808406292f849431baa6e662");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "product_table","provider_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `product_table`");
      _db.execSQL("DELETE FROM `provider_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProviderDao.class, ProviderDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public ProductDao productDao() {
    if (_productDao != null) {
      return _productDao;
    } else {
      synchronized(this) {
        if(_productDao == null) {
          _productDao = new ProductDao_Impl(this);
        }
        return _productDao;
      }
    }
  }

  @Override
  public ProviderDao providerDao() {
    if (_providerDao != null) {
      return _providerDao;
    } else {
      synchronized(this) {
        if(_providerDao == null) {
          _providerDao = new ProviderDao_Impl(this);
        }
        return _providerDao;
      }
    }
  }
}
