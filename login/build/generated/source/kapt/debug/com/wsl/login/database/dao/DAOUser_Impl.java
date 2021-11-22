package com.wsl.login.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.wsl.login.database.entities.EUser;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOUser_Impl implements DAOUser {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EUser> __insertionAdapterOfEUser;

  private final EntityDeletionOrUpdateAdapter<EUser> __updateAdapterOfEUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUsers;

  public DAOUser_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEUser = new EntityInsertionAdapter<EUser>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `User` (`uuid_user`,`google_uid`,`customer_id`,`name`,`last_name`,`username`,`email`,`country`,`state`,`city`,`postal_code`,`country_code`,`phone`,`address`,`latitude`,`longitude`,`sex`,`typeOfUser`,`tokendevice`,`image_uri`,`password`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EUser value) {
        if (value.getUuid_user() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid_user());
        }
        if (value.getGoogle_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGoogle_uid());
        }
        if (value.getCustomer_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCustomer_id());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getLast_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLast_name());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUsername());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCountry());
        }
        if (value.getState() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getState());
        }
        if (value.getCity() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCity());
        }
        if (value.getPostal_code() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPostal_code());
        }
        if (value.getCountry_code() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCountry_code());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhone());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAddress());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLongitude());
        }
        if (value.getSex() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSex());
        }
        if (value.getTypeOfUser() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTypeOfUser());
        }
        if (value.getTokendevice() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTokendevice());
        }
        if (value.getImage_uri() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImage_uri());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getPassword());
        }
      }
    };
    this.__updateAdapterOfEUser = new EntityDeletionOrUpdateAdapter<EUser>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `User` SET `uuid_user` = ?,`google_uid` = ?,`customer_id` = ?,`name` = ?,`last_name` = ?,`username` = ?,`email` = ?,`country` = ?,`state` = ?,`city` = ?,`postal_code` = ?,`country_code` = ?,`phone` = ?,`address` = ?,`latitude` = ?,`longitude` = ?,`sex` = ?,`typeOfUser` = ?,`tokendevice` = ?,`image_uri` = ?,`password` = ? WHERE `uuid_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EUser value) {
        if (value.getUuid_user() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUuid_user());
        }
        if (value.getGoogle_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGoogle_uid());
        }
        if (value.getCustomer_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCustomer_id());
        }
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getLast_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLast_name());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getUsername());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCountry());
        }
        if (value.getState() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getState());
        }
        if (value.getCity() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCity());
        }
        if (value.getPostal_code() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPostal_code());
        }
        if (value.getCountry_code() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCountry_code());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPhone());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAddress());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLongitude());
        }
        if (value.getSex() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSex());
        }
        if (value.getTypeOfUser() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTypeOfUser());
        }
        if (value.getTokendevice() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTokendevice());
        }
        if (value.getImage_uri() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImage_uri());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getPassword());
        }
        if (value.getUuid_user() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getUuid_user());
        }
      }
    };
    this.__preparedStmtOfDeleteUsers = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM User ";
        return _query;
      }
    };
  }

  @Override
  public void insertUser(final EUser user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EUser user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUsers() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUsers.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUsers.release(_stmt);
    }
  }

  @Override
  public EUser signIn() {
    final String _sql = "SELECT * FROM User ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuidUser = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid_user");
      final int _cursorIndexOfGoogleUid = CursorUtil.getColumnIndexOrThrow(_cursor, "google_uid");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfPostalCode = CursorUtil.getColumnIndexOrThrow(_cursor, "postal_code");
      final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
      final int _cursorIndexOfTypeOfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "typeOfUser");
      final int _cursorIndexOfTokendevice = CursorUtil.getColumnIndexOrThrow(_cursor, "tokendevice");
      final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final EUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUuid_user;
        if (_cursor.isNull(_cursorIndexOfUuidUser)) {
          _tmpUuid_user = null;
        } else {
          _tmpUuid_user = _cursor.getString(_cursorIndexOfUuidUser);
        }
        final String _tmpGoogle_uid;
        if (_cursor.isNull(_cursorIndexOfGoogleUid)) {
          _tmpGoogle_uid = null;
        } else {
          _tmpGoogle_uid = _cursor.getString(_cursorIndexOfGoogleUid);
        }
        final String _tmpCustomer_id;
        if (_cursor.isNull(_cursorIndexOfCustomerId)) {
          _tmpCustomer_id = null;
        } else {
          _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpLast_name;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLast_name = null;
        } else {
          _tmpLast_name = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        final String _tmpState;
        if (_cursor.isNull(_cursorIndexOfState)) {
          _tmpState = null;
        } else {
          _tmpState = _cursor.getString(_cursorIndexOfState);
        }
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        final String _tmpPostal_code;
        if (_cursor.isNull(_cursorIndexOfPostalCode)) {
          _tmpPostal_code = null;
        } else {
          _tmpPostal_code = _cursor.getString(_cursorIndexOfPostalCode);
        }
        final String _tmpCountry_code;
        if (_cursor.isNull(_cursorIndexOfCountryCode)) {
          _tmpCountry_code = null;
        } else {
          _tmpCountry_code = _cursor.getString(_cursorIndexOfCountryCode);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        final String _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getString(_cursorIndexOfLongitude);
        }
        final String _tmpSex;
        if (_cursor.isNull(_cursorIndexOfSex)) {
          _tmpSex = null;
        } else {
          _tmpSex = _cursor.getString(_cursorIndexOfSex);
        }
        final String _tmpTypeOfUser;
        if (_cursor.isNull(_cursorIndexOfTypeOfUser)) {
          _tmpTypeOfUser = null;
        } else {
          _tmpTypeOfUser = _cursor.getString(_cursorIndexOfTypeOfUser);
        }
        final String _tmpTokendevice;
        if (_cursor.isNull(_cursorIndexOfTokendevice)) {
          _tmpTokendevice = null;
        } else {
          _tmpTokendevice = _cursor.getString(_cursorIndexOfTokendevice);
        }
        final String _tmpImage_uri;
        if (_cursor.isNull(_cursorIndexOfImageUri)) {
          _tmpImage_uri = null;
        } else {
          _tmpImage_uri = _cursor.getString(_cursorIndexOfImageUri);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _result = new EUser(_tmpUuid_user,_tmpGoogle_uid,_tmpCustomer_id,_tmpName,_tmpLast_name,_tmpUsername,_tmpEmail,_tmpCountry,_tmpState,_tmpCity,_tmpPostal_code,_tmpCountry_code,_tmpPhone,_tmpAddress,_tmpLatitude,_tmpLongitude,_tmpSex,_tmpTypeOfUser,_tmpTokendevice,_tmpImage_uri,_tmpPassword);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String isUserExist(final String email) {
    final String _sql = "SELECT uuid_user FROM User WHERE email == ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public EUser getUser() {
    final String _sql = "SELECT * FROM User ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUuidUser = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid_user");
      final int _cursorIndexOfGoogleUid = CursorUtil.getColumnIndexOrThrow(_cursor, "google_uid");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfPostalCode = CursorUtil.getColumnIndexOrThrow(_cursor, "postal_code");
      final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
      final int _cursorIndexOfTypeOfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "typeOfUser");
      final int _cursorIndexOfTokendevice = CursorUtil.getColumnIndexOrThrow(_cursor, "tokendevice");
      final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final EUser _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUuid_user;
        if (_cursor.isNull(_cursorIndexOfUuidUser)) {
          _tmpUuid_user = null;
        } else {
          _tmpUuid_user = _cursor.getString(_cursorIndexOfUuidUser);
        }
        final String _tmpGoogle_uid;
        if (_cursor.isNull(_cursorIndexOfGoogleUid)) {
          _tmpGoogle_uid = null;
        } else {
          _tmpGoogle_uid = _cursor.getString(_cursorIndexOfGoogleUid);
        }
        final String _tmpCustomer_id;
        if (_cursor.isNull(_cursorIndexOfCustomerId)) {
          _tmpCustomer_id = null;
        } else {
          _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpLast_name;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLast_name = null;
        } else {
          _tmpLast_name = _cursor.getString(_cursorIndexOfLastName);
        }
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpCountry;
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _tmpCountry = null;
        } else {
          _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        }
        final String _tmpState;
        if (_cursor.isNull(_cursorIndexOfState)) {
          _tmpState = null;
        } else {
          _tmpState = _cursor.getString(_cursorIndexOfState);
        }
        final String _tmpCity;
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _tmpCity = null;
        } else {
          _tmpCity = _cursor.getString(_cursorIndexOfCity);
        }
        final String _tmpPostal_code;
        if (_cursor.isNull(_cursorIndexOfPostalCode)) {
          _tmpPostal_code = null;
        } else {
          _tmpPostal_code = _cursor.getString(_cursorIndexOfPostalCode);
        }
        final String _tmpCountry_code;
        if (_cursor.isNull(_cursorIndexOfCountryCode)) {
          _tmpCountry_code = null;
        } else {
          _tmpCountry_code = _cursor.getString(_cursorIndexOfCountryCode);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        final String _tmpLongitude;
        if (_cursor.isNull(_cursorIndexOfLongitude)) {
          _tmpLongitude = null;
        } else {
          _tmpLongitude = _cursor.getString(_cursorIndexOfLongitude);
        }
        final String _tmpSex;
        if (_cursor.isNull(_cursorIndexOfSex)) {
          _tmpSex = null;
        } else {
          _tmpSex = _cursor.getString(_cursorIndexOfSex);
        }
        final String _tmpTypeOfUser;
        if (_cursor.isNull(_cursorIndexOfTypeOfUser)) {
          _tmpTypeOfUser = null;
        } else {
          _tmpTypeOfUser = _cursor.getString(_cursorIndexOfTypeOfUser);
        }
        final String _tmpTokendevice;
        if (_cursor.isNull(_cursorIndexOfTokendevice)) {
          _tmpTokendevice = null;
        } else {
          _tmpTokendevice = _cursor.getString(_cursorIndexOfTokendevice);
        }
        final String _tmpImage_uri;
        if (_cursor.isNull(_cursorIndexOfImageUri)) {
          _tmpImage_uri = null;
        } else {
          _tmpImage_uri = _cursor.getString(_cursorIndexOfImageUri);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _result = new EUser(_tmpUuid_user,_tmpGoogle_uid,_tmpCustomer_id,_tmpName,_tmpLast_name,_tmpUsername,_tmpEmail,_tmpCountry,_tmpState,_tmpCity,_tmpPostal_code,_tmpCountry_code,_tmpPhone,_tmpAddress,_tmpLatitude,_tmpLongitude,_tmpSex,_tmpTypeOfUser,_tmpTokendevice,_tmpImage_uri,_tmpPassword);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EUser> getUserLiveData() {
    final String _sql = "SELECT * FROM User ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User"}, false, new Callable<EUser>() {
      @Override
      public EUser call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUuidUser = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid_user");
          final int _cursorIndexOfGoogleUid = CursorUtil.getColumnIndexOrThrow(_cursor, "google_uid");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customer_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "last_name");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfPostalCode = CursorUtil.getColumnIndexOrThrow(_cursor, "postal_code");
          final int _cursorIndexOfCountryCode = CursorUtil.getColumnIndexOrThrow(_cursor, "country_code");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfSex = CursorUtil.getColumnIndexOrThrow(_cursor, "sex");
          final int _cursorIndexOfTypeOfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "typeOfUser");
          final int _cursorIndexOfTokendevice = CursorUtil.getColumnIndexOrThrow(_cursor, "tokendevice");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "image_uri");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final EUser _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUuid_user;
            if (_cursor.isNull(_cursorIndexOfUuidUser)) {
              _tmpUuid_user = null;
            } else {
              _tmpUuid_user = _cursor.getString(_cursorIndexOfUuidUser);
            }
            final String _tmpGoogle_uid;
            if (_cursor.isNull(_cursorIndexOfGoogleUid)) {
              _tmpGoogle_uid = null;
            } else {
              _tmpGoogle_uid = _cursor.getString(_cursorIndexOfGoogleUid);
            }
            final String _tmpCustomer_id;
            if (_cursor.isNull(_cursorIndexOfCustomerId)) {
              _tmpCustomer_id = null;
            } else {
              _tmpCustomer_id = _cursor.getString(_cursorIndexOfCustomerId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpLast_name;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLast_name = null;
            } else {
              _tmpLast_name = _cursor.getString(_cursorIndexOfLastName);
            }
            final String _tmpUsername;
            if (_cursor.isNull(_cursorIndexOfUsername)) {
              _tmpUsername = null;
            } else {
              _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final String _tmpState;
            if (_cursor.isNull(_cursorIndexOfState)) {
              _tmpState = null;
            } else {
              _tmpState = _cursor.getString(_cursorIndexOfState);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final String _tmpPostal_code;
            if (_cursor.isNull(_cursorIndexOfPostalCode)) {
              _tmpPostal_code = null;
            } else {
              _tmpPostal_code = _cursor.getString(_cursorIndexOfPostalCode);
            }
            final String _tmpCountry_code;
            if (_cursor.isNull(_cursorIndexOfCountryCode)) {
              _tmpCountry_code = null;
            } else {
              _tmpCountry_code = _cursor.getString(_cursorIndexOfCountryCode);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            final String _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getString(_cursorIndexOfLongitude);
            }
            final String _tmpSex;
            if (_cursor.isNull(_cursorIndexOfSex)) {
              _tmpSex = null;
            } else {
              _tmpSex = _cursor.getString(_cursorIndexOfSex);
            }
            final String _tmpTypeOfUser;
            if (_cursor.isNull(_cursorIndexOfTypeOfUser)) {
              _tmpTypeOfUser = null;
            } else {
              _tmpTypeOfUser = _cursor.getString(_cursorIndexOfTypeOfUser);
            }
            final String _tmpTokendevice;
            if (_cursor.isNull(_cursorIndexOfTokendevice)) {
              _tmpTokendevice = null;
            } else {
              _tmpTokendevice = _cursor.getString(_cursorIndexOfTokendevice);
            }
            final String _tmpImage_uri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImage_uri = null;
            } else {
              _tmpImage_uri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final String _tmpPassword;
            if (_cursor.isNull(_cursorIndexOfPassword)) {
              _tmpPassword = null;
            } else {
              _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            }
            _result = new EUser(_tmpUuid_user,_tmpGoogle_uid,_tmpCustomer_id,_tmpName,_tmpLast_name,_tmpUsername,_tmpEmail,_tmpCountry,_tmpState,_tmpCity,_tmpPostal_code,_tmpCountry_code,_tmpPhone,_tmpAddress,_tmpLatitude,_tmpLongitude,_tmpSex,_tmpTypeOfUser,_tmpTokendevice,_tmpImage_uri,_tmpPassword);
          } else {
            _result = null;
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
