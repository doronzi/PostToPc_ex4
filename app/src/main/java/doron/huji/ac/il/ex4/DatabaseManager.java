package doron.huji.ac.il.ex4;

/**
 * Created by Doron on 26/04/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final int database_version = 1;

    DatabaseManager(Context context) {
        super(context, DataTable.TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        String CREATE_QUERY = "CREATE TABLE tasksTable(taskName TEXT, taskID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL);";
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void putInformation(DatabaseManager dop, String taskName){

        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DataTable.TableInfo.TASK_NAME, taskName);

        SQ.insert(DataTable.TableInfo.TABLE_NAME, null, cv);
    }

    Cursor getInformation(DatabaseManager dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {DataTable.TableInfo.TASK_NAME, DataTable.TableInfo.TASK_ID};

        return SQ.query(DataTable.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
    }

    void deleteTask(DatabaseManager dop, int taskID) {
        String selection = DataTable.TableInfo.TASK_ID + " LIKE ? ";
        String args[] = {String.valueOf(taskID)};
        SQLiteDatabase SQ = dop.getWritableDatabase();
        SQ.delete(DataTable.TableInfo.TABLE_NAME, selection, args);
    }
}
