package ru.nightgoat.volunteer.data.db;

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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VolunteerDatabase_Impl extends VolunteerDatabase {
  private volatile mDao _mDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LocationEventsEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `creationDate` INTEGER NOT NULL, `type` TEXT NOT NULL, `description` TEXT NOT NULL, `eventDate` INTEGER NOT NULL, `isOver` INTEGER NOT NULL, `ownerId` INTEGER NOT NULL, `inProgress` INTEGER NOT NULL, `locationId` INTEGER NOT NULL, `locationLon` REAL NOT NULL, `locationLat` REAL NOT NULL, `locationAddress` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c7facdbbaec761cec69fe617567cdc84')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `LocationEventsEntity`");
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
        final HashMap<String, TableInfo.Column> _columnsLocationEventsEntity = new HashMap<String, TableInfo.Column>(13);
        _columnsLocationEventsEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("creationDate", new TableInfo.Column("creationDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("eventDate", new TableInfo.Column("eventDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("isOver", new TableInfo.Column("isOver", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("ownerId", new TableInfo.Column("ownerId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("inProgress", new TableInfo.Column("inProgress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("locationId", new TableInfo.Column("locationId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("locationLon", new TableInfo.Column("locationLon", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("locationLat", new TableInfo.Column("locationLat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationEventsEntity.put("locationAddress", new TableInfo.Column("locationAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationEventsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationEventsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationEventsEntity = new TableInfo("LocationEventsEntity", _columnsLocationEventsEntity, _foreignKeysLocationEventsEntity, _indicesLocationEventsEntity);
        final TableInfo _existingLocationEventsEntity = TableInfo.read(_db, "LocationEventsEntity");
        if (! _infoLocationEventsEntity.equals(_existingLocationEventsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "LocationEventsEntity(ru.nightgoat.volunteer.data.db.entity.LocationEventsEntity).\n"
                  + " Expected:\n" + _infoLocationEventsEntity + "\n"
                  + " Found:\n" + _existingLocationEventsEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c7facdbbaec761cec69fe617567cdc84", "3b3f133bdb24bc1b4284ed67bf6137e4");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "LocationEventsEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `LocationEventsEntity`");
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
  public mDao dao() {
    if (_mDao != null) {
      return _mDao;
    } else {
      synchronized(this) {
        if(_mDao == null) {
          _mDao = new mDao_Impl(this);
        }
        return _mDao;
      }
    }
  }
}
