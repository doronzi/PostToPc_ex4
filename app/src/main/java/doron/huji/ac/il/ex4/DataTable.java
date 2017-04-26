package doron.huji.ac.il.ex4;

/**
 * Created by Doron on 26/04/2017.
 */

import android.provider.BaseColumns;

public class DataTable {
    public DataTable() {}

    static abstract class TableInfo implements BaseColumns {

        static final String TASK_NAME = "taskName";
        static final String TASK_ID = "taskID";
        static final String DATABASE_NAME = "tasksDatabase";
        static final String TABLE_NAME = "tasksTable";
    }
}
