package com.wsl.login.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wsl.login.database.entities.ECard;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOCard_Impl implements DAOCard {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECard> __insertionAdapterOfECard;

  public DAOCard_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECard = new EntityInsertionAdapter<ECard>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Card` (`id`,`type`,`brand`,`address`,`card_number`,`holder_name`,`expiration_year`,`expiration_month`,`allows_charges`,`allows_payouts`,`creation_date`,`bank_name`,`customer_id`,`bank_code`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECard value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getType());
        }
        if (value.getBrand() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBrand());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getCard_number() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCard_number());
        }
        if (value.getHolder_name() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHolder_name());
        }
        if (value.getExpiration_year() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getExpiration_year());
        }
        if (value.getExpiration_month() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getExpiration_month());
        }
        if (value.getAllows_charges() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAllows_charges());
        }
        if (value.getAllows_payouts() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAllows_payouts());
        }
        if (value.getCreation_date() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCreation_date());
        }
        if (value.getBank_name() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBank_name());
        }
        if (value.getCustomer_id() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCustomer_id());
        }
        if (value.getBank_code() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getBank_code());
        }
      }
    };
  }

  @Override
  public void saveCardList(final List<ECard> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECard.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ECard>> getCardsLiveData() {
    final String _sql = "SELECT * FROM card";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"card"}, false, new Callable<List<ECard>>() {
      @Override
      public List<ECard> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "brand");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfCardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "card_number");
          final int _cursorIndexOfHolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "holder_name");
          final int _cursorIndexOfExpirationYear = CursorUtil.getColumnIndexOrThrow(_cursor, "expiration_year");
          final int _cursorIndexOfExpirationMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "expiration_month");
          final int _cursorIndexOfAllowsCharges = CursorUtil.getColumnIndexOrThrow(_cursor, "allows_charges");
          final int _cursorIndexOfAllowsPayouts = CursorUtil.getColumnIndexOrThrow(_cursor, "allows_payouts");
          final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bank_name");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
          final int _cursorIndexOfBankCode = CursorUtil.getColumnIndexOrThrow(_cursor, "bank_code");
          final List<ECard> _result = new ArrayList<ECard>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECard _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpBrand;
            _tmpBrand = _cursor.getString(_cursorIndexOfBrand);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final String _tmpCard_number;
            _tmpCard_number = _cursor.getString(_cursorIndexOfCardNumber);
            final String _tmpHolder_name;
            _tmpHolder_name = _cursor.getString(_cursorIndexOfHolderName);
            final String _tmpExpiration_year;
            _tmpExpiration_year = _cursor.getString(_cursorIndexOfExpirationYear);
            final String _tmpExpiration_month;
            _tmpExpiration_month = _cursor.getString(_cursorIndexOfExpirationMonth);
            final String _tmpAllows_charges;
            _tmpAllows_charges = _cursor.getString(_cursorIndexOfAllowsCharges);
            final String _tmpAllows_payouts;
            _tmpAllows_payouts = _cursor.getString(_cursorIndexOfAllowsPayouts);
            final String _tmpCreation_date;
            _tmpCreation_date = _cursor.getString(_cursorIndexOfCreationDate);
            final String _tmpBank_name;
            _tmpBank_name = _cursor.getString(_cursorIndexOfBankName);
            final String _tmpCustomer_id;
            _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpBank_code;
            _tmpBank_code = _cursor.getString(_cursorIndexOfBankCode);
            _item = new ECard(_tmpId,_tmpType,_tmpBrand,_tmpAddress,_tmpCard_number,_tmpHolder_name,_tmpExpiration_year,_tmpExpiration_month,_tmpAllows_charges,_tmpAllows_payouts,_tmpCreation_date,_tmpBank_name,_tmpCustomer_id,_tmpBank_code);
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

  @Override
  public List<ECard> getCards() {
    final String _sql = "SELECT * FROM card";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "brand");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfCardNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "card_number");
      final int _cursorIndexOfHolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "holder_name");
      final int _cursorIndexOfExpirationYear = CursorUtil.getColumnIndexOrThrow(_cursor, "expiration_year");
      final int _cursorIndexOfExpirationMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "expiration_month");
      final int _cursorIndexOfAllowsCharges = CursorUtil.getColumnIndexOrThrow(_cursor, "allows_charges");
      final int _cursorIndexOfAllowsPayouts = CursorUtil.getColumnIndexOrThrow(_cursor, "allows_payouts");
      final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bank_name");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
      final int _cursorIndexOfBankCode = CursorUtil.getColumnIndexOrThrow(_cursor, "bank_code");
      final List<ECard> _result = new ArrayList<ECard>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECard _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpBrand;
        _tmpBrand = _cursor.getString(_cursorIndexOfBrand);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        final String _tmpCard_number;
        _tmpCard_number = _cursor.getString(_cursorIndexOfCardNumber);
        final String _tmpHolder_name;
        _tmpHolder_name = _cursor.getString(_cursorIndexOfHolderName);
        final String _tmpExpiration_year;
        _tmpExpiration_year = _cursor.getString(_cursorIndexOfExpirationYear);
        final String _tmpExpiration_month;
        _tmpExpiration_month = _cursor.getString(_cursorIndexOfExpirationMonth);
        final String _tmpAllows_charges;
        _tmpAllows_charges = _cursor.getString(_cursorIndexOfAllowsCharges);
        final String _tmpAllows_payouts;
        _tmpAllows_payouts = _cursor.getString(_cursorIndexOfAllowsPayouts);
        final String _tmpCreation_date;
        _tmpCreation_date = _cursor.getString(_cursorIndexOfCreationDate);
        final String _tmpBank_name;
        _tmpBank_name = _cursor.getString(_cursorIndexOfBankName);
        final String _tmpCustomer_id;
        _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
        final String _tmpBank_code;
        _tmpBank_code = _cursor.getString(_cursorIndexOfBankCode);
        _item = new ECard(_tmpId,_tmpType,_tmpBrand,_tmpAddress,_tmpCard_number,_tmpHolder_name,_tmpExpiration_year,_tmpExpiration_month,_tmpAllows_charges,_tmpAllows_payouts,_tmpCreation_date,_tmpBank_name,_tmpCustomer_id,_tmpBank_code);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
