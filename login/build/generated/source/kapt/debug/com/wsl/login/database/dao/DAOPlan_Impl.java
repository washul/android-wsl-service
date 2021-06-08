package com.wsl.login.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wsl.login.database.entities.EPlan;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOPlan_Impl implements DAOPlan {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPlan> __insertionAdapterOfEPlan;

  public DAOPlan_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPlan = new EntityInsertionAdapter<EPlan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Plan` (`planID`,`name`,`amount`,`creation_date`,`repeat_every`,`repeat_unit`,`retry_times`,`status`,`status_after_retry`,`trial_days`,`currency`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPlan value) {
        if (value.getPlanID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlanID());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAmount() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAmount());
        }
        if (value.getCreation_date() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreation_date());
        }
        if (value.getRepeat_every() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRepeat_every());
        }
        if (value.getRepeat_unit() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRepeat_unit());
        }
        if (value.getRetry_times() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRetry_times());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStatus());
        }
        if (value.getStatus_after_retry() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStatus_after_retry());
        }
        if (value.getTrial_days() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTrial_days());
        }
        if (value.getCurrency() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCurrency());
        }
      }
    };
  }

  @Override
  public void save(final EPlan plan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPlan.insert(plan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EPlan> get() {
    final String _sql = "SELECT * FROM `plan`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPlanID = CursorUtil.getColumnIndexOrThrow(_cursor, "planID");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
      final int _cursorIndexOfRepeatEvery = CursorUtil.getColumnIndexOrThrow(_cursor, "repeat_every");
      final int _cursorIndexOfRepeatUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "repeat_unit");
      final int _cursorIndexOfRetryTimes = CursorUtil.getColumnIndexOrThrow(_cursor, "retry_times");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfStatusAfterRetry = CursorUtil.getColumnIndexOrThrow(_cursor, "status_after_retry");
      final int _cursorIndexOfTrialDays = CursorUtil.getColumnIndexOrThrow(_cursor, "trial_days");
      final int _cursorIndexOfCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "currency");
      final List<EPlan> _result = new ArrayList<EPlan>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EPlan _item;
        final String _tmpPlanID;
        _tmpPlanID = _cursor.getString(_cursorIndexOfPlanID);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpAmount;
        _tmpAmount = _cursor.getString(_cursorIndexOfAmount);
        final String _tmpCreation_date;
        _tmpCreation_date = _cursor.getString(_cursorIndexOfCreationDate);
        final String _tmpRepeat_every;
        _tmpRepeat_every = _cursor.getString(_cursorIndexOfRepeatEvery);
        final String _tmpRepeat_unit;
        _tmpRepeat_unit = _cursor.getString(_cursorIndexOfRepeatUnit);
        final String _tmpRetry_times;
        _tmpRetry_times = _cursor.getString(_cursorIndexOfRetryTimes);
        final String _tmpStatus;
        _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        final String _tmpStatus_after_retry;
        _tmpStatus_after_retry = _cursor.getString(_cursorIndexOfStatusAfterRetry);
        final String _tmpTrial_days;
        _tmpTrial_days = _cursor.getString(_cursorIndexOfTrialDays);
        final String _tmpCurrency;
        _tmpCurrency = _cursor.getString(_cursorIndexOfCurrency);
        _item = new EPlan(_tmpPlanID,_tmpName,_tmpAmount,_tmpCreation_date,_tmpRepeat_every,_tmpRepeat_unit,_tmpRetry_times,_tmpStatus,_tmpStatus_after_retry,_tmpTrial_days,_tmpCurrency);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
