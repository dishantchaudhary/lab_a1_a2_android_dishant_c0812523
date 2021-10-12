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
public final class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Product> __insertionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __deletionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __updateAdapterOfProduct;

  public ProductDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `product_table` (`productId`,`productName`,`productDescription`,`productPrice`,`productProvider`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        stmt.bindLong(1, value.getProductId());
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        if (value.getProductDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductDescription());
        }
        if (value.getProductPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getProductPrice());
        }
        if (value.getProductProvider() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProductProvider());
        }
      }
    };
    this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `product_table` WHERE `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        stmt.bindLong(1, value.getProductId());
      }
    };
    this.__updateAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `product_table` SET `productId` = ?,`productName` = ?,`productDescription` = ?,`productPrice` = ?,`productProvider` = ? WHERE `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        stmt.bindLong(1, value.getProductId());
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        if (value.getProductDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductDescription());
        }
        if (value.getProductPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.getProductPrice());
        }
        if (value.getProductProvider() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProductProvider());
        }
        stmt.bindLong(6, value.getProductId());
      }
    };
  }

  @Override
  public void insert(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduct.insert(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProduct.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Product product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProduct.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Product>> getAllProducts() {
    final String _sql = "SELECT * FROM product_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"product_table"}, false, new Callable<List<Product>>() {
      @Override
      public List<Product> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "productName");
          final int _cursorIndexOfProductDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "productDescription");
          final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "productPrice");
          final int _cursorIndexOfProductProvider = CursorUtil.getColumnIndexOrThrow(_cursor, "productProvider");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Product _item;
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final String _tmpProductDescription;
            if (_cursor.isNull(_cursorIndexOfProductDescription)) {
              _tmpProductDescription = null;
            } else {
              _tmpProductDescription = _cursor.getString(_cursorIndexOfProductDescription);
            }
            final Double _tmpProductPrice;
            if (_cursor.isNull(_cursorIndexOfProductPrice)) {
              _tmpProductPrice = null;
            } else {
              _tmpProductPrice = _cursor.getDouble(_cursorIndexOfProductPrice);
            }
            final String _tmpProductProvider;
            if (_cursor.isNull(_cursorIndexOfProductProvider)) {
              _tmpProductProvider = null;
            } else {
              _tmpProductProvider = _cursor.getString(_cursorIndexOfProductProvider);
            }
            _item = new Product(_tmpProductName,_tmpProductDescription,_tmpProductPrice,_tmpProductProvider);
            final int _tmpProductId;
            _tmpProductId = _cursor.getInt(_cursorIndexOfProductId);
            _item.setProductId(_tmpProductId);
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
