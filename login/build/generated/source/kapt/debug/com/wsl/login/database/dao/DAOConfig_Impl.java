package com.wsl.login.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wsl.login.database.entities.EConfig;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOConfig_Impl implements DAOConfig {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EConfig> __insertionAdapterOfEConfig;

  public DAOConfig_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEConfig = new EntityInsertionAdapter<EConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `config` (`project_id`,`project_icon`,`project_name`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EConfig value) {
        if (value.getProject_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProject_id());
        }
        if (value.getProject_icon() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProject_icon());
        }
        if (value.getProject_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProject_name());
        }
      }
    };
  }

  @Override
  public void insert(final EConfig config) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEConfig.insert(config);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EConfig get() {
    final String _sql = "SELECT * FROM config";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "project_id");
      final int _cursorIndexOfProjectIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "project_icon");
      final int _cursorIndexOfProjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "project_name");
      final EConfig _result;
      if(_cursor.moveToFirst()) {
        final String _tmpProject_id;
        if (_cursor.isNull(_cursorIndexOfProjectId)) {
          _tmpProject_id = null;
        } else {
          _tmpProject_id = _cursor.getString(_cursorIndexOfProjectId);
        }
        final String _tmpProject_icon;
        if (_cursor.isNull(_cursorIndexOfProjectIcon)) {
          _tmpProject_icon = null;
        } else {
          _tmpProject_icon = _cursor.getString(_cursorIndexOfProjectIcon);
        }
        final String _tmpProject_name;
        if (_cursor.isNull(_cursorIndexOfProjectName)) {
          _tmpProject_name = null;
        } else {
          _tmpProject_name = _cursor.getString(_cursorIndexOfProjectName);
        }
        _result = new EConfig(_tmpProject_id,_tmpProject_icon,_tmpProject_name);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
