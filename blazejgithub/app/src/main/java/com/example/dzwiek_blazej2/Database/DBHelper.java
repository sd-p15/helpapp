package com.example.dzwiek_blazej2.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dzwiek_blazej2.Models.RecordingItem;


public class DBHelper extends SQLiteOpenHelper
{
   private Context context;
   public static final String DATABASE_NAME = "saved_recordings.db";
   private static final int DATABASE_VERSION = 1;
   public static final String TABLE_NAME = "save_recording_table";


   public static final String COLUMN_NAME = "name";
   public static final String COLUMN_PATH = "path";
   public static final String COLUMN_LENGTH = "lenght";
   public static final String COLUMN_TIME_ADDED = "time_addied";

   private static final String COMA_SEP = ",";

   private static final String SQLITE_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("+"id INTEGER PRIMARY KEY " +
           "AUTOINCREMENT"+COMA_SEP+
           COLUMN_NAME + " TEXT" + COMA_SEP +
           COLUMN_PATH + " TEXT" + COMA_SEP +
           COLUMN_LENGTH + " INTEGER" + COMA_SEP +
           COLUMN_TIME_ADDED + " INTEGER" + ")";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,  null,DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLITE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean addRecording (RecordingItem recordingItem)
    {
        try
        {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_NAME,recordingItem.getName());
            contentValues.put(COLUMN_PATH,recordingItem.getPath());
            contentValues.put(COLUMN_LENGTH,recordingItem.getLength());
            contentValues.put(COLUMN_TIME_ADDED,recordingItem.getTime_added());

            db.insert(TABLE_NAME, null,contentValues);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
}
