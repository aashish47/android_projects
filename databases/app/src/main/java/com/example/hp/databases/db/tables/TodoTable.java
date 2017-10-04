package com.example.hp.databases.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hp.databases.models.Todo;

import java.util.ArrayList;

import static com.example.hp.databases.db.tables.DbConsts.CMD_ADD_COLUMN;
import static com.example.hp.databases.db.tables.DbConsts.CMD_ALTER_TABLE;
import static com.example.hp.databases.db.tables.DbConsts.CMD_CREATE_TABLE_INE;
import static com.example.hp.databases.db.tables.DbConsts.COMMA;
import static com.example.hp.databases.db.tables.DbConsts.LBR;
import static com.example.hp.databases.db.tables.DbConsts.RBR;
import static com.example.hp.databases.db.tables.DbConsts.SEMI;
import static com.example.hp.databases.db.tables.DbConsts.TYPE_AI;
import static com.example.hp.databases.db.tables.DbConsts.TYPE_BOOL;
import static com.example.hp.databases.db.tables.DbConsts.TYPE_INT;
import static com.example.hp.databases.db.tables.DbConsts.TYPE_PK;
import static com.example.hp.databases.db.tables.DbConsts.TYPE_TEXT;
import static com.example.hp.databases.db.tables.TodoTable.Columns.DONE;

/**
 * Created by Hp on 9/29/2017.
 */

public class TodoTable {
    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Columns.ID + TYPE_INT + TYPE_PK + TYPE_AI + COMMA +
                    Columns.TASK + TYPE_TEXT + COMMA +
                    DONE + TYPE_BOOL +
                    RBR +
                    SEMI;

    public static final String CMD_UPD_1_2 =
            CMD_ALTER_TABLE + TABLE_NAME +
                    CMD_ADD_COLUMN +
                    DONE + TYPE_BOOL +
                    SEMI;


    public static ArrayList<Todo> getAllTodos (SQLiteDatabase db) {
        ArrayList<Todo> todos = new ArrayList<>();

        Cursor c = db.query(
                TABLE_NAME,
                new String[] {Columns.ID, Columns.TASK, DONE},
                null,
                null,
                null,
                null,
                null
        );
        int colForId = c.getColumnIndex(Columns.ID);
        int colForTask = c.getColumnIndex(Columns.TASK);
        int colForDone = c.getColumnIndex(Columns.DONE);
        while (c.moveToNext()) {
            todos.add(
                    new Todo(
                            c.getInt(colForId),
                            c.getString(colForTask),
                            c.getInt(colForDone) != 0
                    )

            );
        }
        return  todos;
    }

    public static long insertTodo (SQLiteDatabase db, Todo todo) {
        ContentValues todoData = new ContentValues();
        todoData.put(Columns.TASK, todo.getTask());
        todoData.put(Columns.DONE, todo.isDone());
        return db.insert(
                TABLE_NAME,
                null,
                todoData
        );
    }

    public static void updateTodo (SQLiteDatabase db,Boolean value,int id){
        ContentValues todoData = new ContentValues();
        todoData.put(Columns.DONE,value);
        db.update(
                TABLE_NAME,
                todoData,
                Columns.ID + "=?",
                new String[]{""+id}
        );
    }

    public static void deleteTodo (SQLiteDatabase db) {
        db.delete(
                TABLE_NAME,
                Columns.DONE + "=?",
                new String[]{"1"}
        );
    }
}
