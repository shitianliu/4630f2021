package com.example.mydesign.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteHelper  extends SQLiteOpenHelper {

    private static SQLiteOpenHelper sqLiteOpenHelper;

    public static synchronized SQLiteOpenHelper getSqLiteOpenHelper(Context context){
        if(sqLiteOpenHelper==null){
            sqLiteOpenHelper=new MySqliteHelper(context,"myProject",null,1);
        }
        return sqLiteOpenHelper;
    }

    public MySqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String usersSql="create table users(_id integer primary key autoincrement ,name text,pwd text)";
        String questionSql="create table question(_id integer primary key autoincrement ,name text,question text,critic text)";
        db.execSQL(usersSql);
        db.execSQL(questionSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
