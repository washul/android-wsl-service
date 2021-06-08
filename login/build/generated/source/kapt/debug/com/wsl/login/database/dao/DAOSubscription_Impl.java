package com.wsl.login.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wsl.login.database.entities.ESubscription;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOSubscription_Impl implements DAOSubscription {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ESubscription> __insertionAdapterOfESubscription;

  public DAOSubscription_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfESubscription = new EntityInsertionAdapter<ESubscription>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Subscription` (`id`,`cancel_at_period_end`,`charge_date`,`creation_date`,`current_period_number`,`period_end_date`,`trial_end_date`,`plan_id`,`customer_id`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESubscription value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        final Integer _tmp;
        _tmp = value.getCancel_at_period_end() == null ? null : (value.getCancel_at_period_end() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getCharge_date() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCharge_date());
        }
        if (value.getCreation_date() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreation_date());
        }
        if (value.getCurrent_period_number() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCurrent_period_number());
        }
        if (value.getPeriod_end_date() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPeriod_end_date());
        }
        if (value.getTrial_end_date() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTrial_end_date());
        }
        if (value.getPlan_id() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPlan_id());
        }
        if (value.getCustomer_id() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCustomer_id());
        }
      }
    };
  }

  @Override
  public void saveSubscription(final ESubscription subscription) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESubscription.insert(subscription);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ESubscription> getSubscriptions() {
    final String _sql = "SELECT * FROM subscription";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCancelAtPeriodEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "cancel_at_period_end");
      final int _cursorIndexOfChargeDate = CursorUtil.getColumnIndexOrThrow(_cursor, "charge_date");
      final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
      final int _cursorIndexOfCurrentPeriodNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "current_period_number");
      final int _cursorIndexOfPeriodEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "period_end_date");
      final int _cursorIndexOfTrialEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "trial_end_date");
      final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "plan_id");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
      final List<ESubscription> _result = new ArrayList<ESubscription>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ESubscription _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final Boolean _tmpCancel_at_period_end;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfCancelAtPeriodEnd)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfCancelAtPeriodEnd);
        }
        _tmpCancel_at_period_end = _tmp == null ? null : _tmp != 0;
        final String _tmpCharge_date;
        _tmpCharge_date = _cursor.getString(_cursorIndexOfChargeDate);
        final String _tmpCreation_date;
        _tmpCreation_date = _cursor.getString(_cursorIndexOfCreationDate);
        final String _tmpCurrent_period_number;
        _tmpCurrent_period_number = _cursor.getString(_cursorIndexOfCurrentPeriodNumber);
        final String _tmpPeriod_end_date;
        _tmpPeriod_end_date = _cursor.getString(_cursorIndexOfPeriodEndDate);
        final String _tmpTrial_end_date;
        _tmpTrial_end_date = _cursor.getString(_cursorIndexOfTrialEndDate);
        final String _tmpPlan_id;
        _tmpPlan_id = _cursor.getString(_cursorIndexOfPlanId);
        final String _tmpCustomer_id;
        _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
        _item = new ESubscription(_tmpId,_tmpCancel_at_period_end,_tmpCharge_date,_tmpCreation_date,_tmpCurrent_period_number,_tmpPeriod_end_date,_tmpTrial_end_date,_tmpPlan_id,_tmpCustomer_id);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
