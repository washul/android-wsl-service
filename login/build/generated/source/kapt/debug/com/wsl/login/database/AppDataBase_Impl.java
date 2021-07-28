package com.wsl.login.database;

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
import com.wsl.login.database.dao.DAOCard;
import com.wsl.login.database.dao.DAOCard_Impl;
import com.wsl.login.database.dao.DAOConfig;
import com.wsl.login.database.dao.DAOConfig_Impl;
import com.wsl.login.database.dao.DAOPlan;
import com.wsl.login.database.dao.DAOPlan_Impl;
import com.wsl.login.database.dao.DAOSubscription;
import com.wsl.login.database.dao.DAOSubscription_Impl;
import com.wsl.login.database.dao.DAOUser;
import com.wsl.login.database.dao.DAOUser_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile DAOUser _dAOUser;

  private volatile DAOCard _dAOCard;

  private volatile DAOSubscription _dAOSubscription;

  private volatile DAOPlan _dAOPlan;

  private volatile DAOConfig _dAOConfig;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`uuid_user` TEXT NOT NULL, `google_uid` TEXT, `customer_id` TEXT, `name` TEXT, `last_name` TEXT, `username` TEXT, `email` TEXT, `country` TEXT, `state` TEXT, `city` TEXT, `postal_code` TEXT, `country_code` TEXT, `phone` TEXT, `address` TEXT, `latitude` TEXT, `longitude` TEXT, `sex` TEXT, `typeOfUser` TEXT, `tokendevice` TEXT, `image_uri` TEXT, `password` TEXT, PRIMARY KEY(`uuid_user`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Card` (`id` TEXT NOT NULL, `type` TEXT, `brand` TEXT, `address` TEXT, `card_number` TEXT, `holder_name` TEXT, `expiration_year` TEXT, `expiration_month` TEXT, `allows_charges` TEXT, `allows_payouts` TEXT, `creation_date` TEXT, `bank_name` TEXT, `customer_id` TEXT, `bank_code` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Subscription` (`id` TEXT NOT NULL, `cancel_at_period_end` INTEGER, `charge_date` TEXT, `creation_date` TEXT, `current_period_number` TEXT, `period_end_date` TEXT, `trial_end_date` TEXT, `plan_id` TEXT, `customer_id` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Plan` (`planID` TEXT NOT NULL, `name` TEXT NOT NULL, `amount` TEXT NOT NULL, `creation_date` TEXT NOT NULL, `repeat_every` TEXT NOT NULL, `repeat_unit` TEXT NOT NULL, `retry_times` TEXT NOT NULL, `status` TEXT NOT NULL, `status_after_retry` TEXT NOT NULL, `trial_days` TEXT NOT NULL, `currency` TEXT NOT NULL, PRIMARY KEY(`planID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `config` (`project_id` TEXT NOT NULL, `project_icon` TEXT NOT NULL, `project_name` TEXT NOT NULL, PRIMARY KEY(`project_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '197ff68380b78aa3484ffb4538adab63')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `Card`");
        _db.execSQL("DROP TABLE IF EXISTS `Subscription`");
        _db.execSQL("DROP TABLE IF EXISTS `Plan`");
        _db.execSQL("DROP TABLE IF EXISTS `config`");
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
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(21);
        _columnsUser.put("uuid_user", new TableInfo.Column("uuid_user", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("google_uid", new TableInfo.Column("google_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("customer_id", new TableInfo.Column("customer_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("last_name", new TableInfo.Column("last_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("state", new TableInfo.Column("state", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("city", new TableInfo.Column("city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("postal_code", new TableInfo.Column("postal_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("country_code", new TableInfo.Column("country_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("latitude", new TableInfo.Column("latitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("longitude", new TableInfo.Column("longitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("sex", new TableInfo.Column("sex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("typeOfUser", new TableInfo.Column("typeOfUser", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("tokendevice", new TableInfo.Column("tokendevice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("image_uri", new TableInfo.Column("image_uri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.wsl.login.database.entities.EUser).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsCard = new HashMap<String, TableInfo.Column>(14);
        _columnsCard.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("brand", new TableInfo.Column("brand", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("card_number", new TableInfo.Column("card_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("holder_name", new TableInfo.Column("holder_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("expiration_year", new TableInfo.Column("expiration_year", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("expiration_month", new TableInfo.Column("expiration_month", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("allows_charges", new TableInfo.Column("allows_charges", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("allows_payouts", new TableInfo.Column("allows_payouts", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("creation_date", new TableInfo.Column("creation_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("bank_name", new TableInfo.Column("bank_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("customer_id", new TableInfo.Column("customer_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCard.put("bank_code", new TableInfo.Column("bank_code", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCard = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCard = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCard = new TableInfo("Card", _columnsCard, _foreignKeysCard, _indicesCard);
        final TableInfo _existingCard = TableInfo.read(_db, "Card");
        if (! _infoCard.equals(_existingCard)) {
          return new RoomOpenHelper.ValidationResult(false, "Card(com.wsl.login.database.entities.ECard).\n"
                  + " Expected:\n" + _infoCard + "\n"
                  + " Found:\n" + _existingCard);
        }
        final HashMap<String, TableInfo.Column> _columnsSubscription = new HashMap<String, TableInfo.Column>(9);
        _columnsSubscription.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("cancel_at_period_end", new TableInfo.Column("cancel_at_period_end", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("charge_date", new TableInfo.Column("charge_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("creation_date", new TableInfo.Column("creation_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("current_period_number", new TableInfo.Column("current_period_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("period_end_date", new TableInfo.Column("period_end_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("trial_end_date", new TableInfo.Column("trial_end_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("plan_id", new TableInfo.Column("plan_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubscription.put("customer_id", new TableInfo.Column("customer_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubscription = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSubscription = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubscription = new TableInfo("Subscription", _columnsSubscription, _foreignKeysSubscription, _indicesSubscription);
        final TableInfo _existingSubscription = TableInfo.read(_db, "Subscription");
        if (! _infoSubscription.equals(_existingSubscription)) {
          return new RoomOpenHelper.ValidationResult(false, "Subscription(com.wsl.login.database.entities.ESubscription).\n"
                  + " Expected:\n" + _infoSubscription + "\n"
                  + " Found:\n" + _existingSubscription);
        }
        final HashMap<String, TableInfo.Column> _columnsPlan = new HashMap<String, TableInfo.Column>(11);
        _columnsPlan.put("planID", new TableInfo.Column("planID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("amount", new TableInfo.Column("amount", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("creation_date", new TableInfo.Column("creation_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("repeat_every", new TableInfo.Column("repeat_every", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("repeat_unit", new TableInfo.Column("repeat_unit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("retry_times", new TableInfo.Column("retry_times", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("status_after_retry", new TableInfo.Column("status_after_retry", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("trial_days", new TableInfo.Column("trial_days", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("currency", new TableInfo.Column("currency", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlan = new TableInfo("Plan", _columnsPlan, _foreignKeysPlan, _indicesPlan);
        final TableInfo _existingPlan = TableInfo.read(_db, "Plan");
        if (! _infoPlan.equals(_existingPlan)) {
          return new RoomOpenHelper.ValidationResult(false, "Plan(com.wsl.login.database.entities.EPlan).\n"
                  + " Expected:\n" + _infoPlan + "\n"
                  + " Found:\n" + _existingPlan);
        }
        final HashMap<String, TableInfo.Column> _columnsConfig = new HashMap<String, TableInfo.Column>(3);
        _columnsConfig.put("project_id", new TableInfo.Column("project_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfig.put("project_icon", new TableInfo.Column("project_icon", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfig.put("project_name", new TableInfo.Column("project_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConfig = new TableInfo("config", _columnsConfig, _foreignKeysConfig, _indicesConfig);
        final TableInfo _existingConfig = TableInfo.read(_db, "config");
        if (! _infoConfig.equals(_existingConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "config(com.wsl.login.database.entities.EConfig).\n"
                  + " Expected:\n" + _infoConfig + "\n"
                  + " Found:\n" + _existingConfig);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "197ff68380b78aa3484ffb4538adab63", "5108060cd94a8c4e1d87834232ab2e5f");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","Card","Subscription","Plan","config");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `Card`");
      _db.execSQL("DELETE FROM `Subscription`");
      _db.execSQL("DELETE FROM `Plan`");
      _db.execSQL("DELETE FROM `config`");
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
  public DAOUser daoUser() {
    if (_dAOUser != null) {
      return _dAOUser;
    } else {
      synchronized(this) {
        if(_dAOUser == null) {
          _dAOUser = new DAOUser_Impl(this);
        }
        return _dAOUser;
      }
    }
  }

  @Override
  public DAOCard daoCard() {
    if (_dAOCard != null) {
      return _dAOCard;
    } else {
      synchronized(this) {
        if(_dAOCard == null) {
          _dAOCard = new DAOCard_Impl(this);
        }
        return _dAOCard;
      }
    }
  }

  @Override
  public DAOSubscription daoSubscription() {
    if (_dAOSubscription != null) {
      return _dAOSubscription;
    } else {
      synchronized(this) {
        if(_dAOSubscription == null) {
          _dAOSubscription = new DAOSubscription_Impl(this);
        }
        return _dAOSubscription;
      }
    }
  }

  @Override
  public DAOPlan daoPlan() {
    if (_dAOPlan != null) {
      return _dAOPlan;
    } else {
      synchronized(this) {
        if(_dAOPlan == null) {
          _dAOPlan = new DAOPlan_Impl(this);
        }
        return _dAOPlan;
      }
    }
  }

  @Override
  public DAOConfig daoConfig() {
    if (_dAOConfig != null) {
      return _dAOConfig;
    } else {
      synchronized(this) {
        if(_dAOConfig == null) {
          _dAOConfig = new DAOConfig_Impl(this);
        }
        return _dAOConfig;
      }
    }
  }
}
