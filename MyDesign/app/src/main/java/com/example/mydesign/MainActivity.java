package com.example.mydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydesign.dataBase.MySqliteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LogIn(View view) {
        SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
        SQLiteDatabase readSql=sqLiteOpenHelper.getReadableDatabase();
        if(readSql.isOpen()){
            EditText username=findViewById(R.id.editTextTextPersonName);
            EditText password=findViewById(R.id.editTextTextPassword);
            String sql="select * from users where name='"+username.getText().toString()+"' and pwd='"+password.getText().toString()+"'";
            Cursor cursor=readSql.rawQuery(sql,null);
            if(cursor.getCount()!=0){
                final CurrentUser currentUser=(CurrentUser)getApplication();
                currentUser.setUsername(username.getText().toString());
                startActivity(new Intent(this,Choice.class));
            }
            else{
                Toast.makeText(this,"The user name or password is incorrect",Toast.LENGTH_LONG).show();
            }
            cursor.close();
            readSql.close();
        }
    }
    public void Register(View view) {
        SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
        SQLiteDatabase readSql=sqLiteOpenHelper.getReadableDatabase();
        if(readSql.isOpen()){
            EditText username=findViewById(R.id.editTextTextPersonName);
            String sql="select * from users where name='"+username.getText()+"'";
            Cursor cursor=readSql.rawQuery(sql,null);
            if(cursor.getCount()!=0){
                Toast.makeText(this,"The user name is already in use",Toast.LENGTH_LONG).show();
                cursor.close();
                readSql.close();
                return;
            }else{
                Toast.makeText(this,"Registration was successful",Toast.LENGTH_LONG).show();
            }
            cursor.close();
            readSql.close();
        }
        SQLiteDatabase writeSql=sqLiteOpenHelper.getWritableDatabase();
        if(writeSql.isOpen()){
            EditText username=findViewById(R.id.editTextTextPersonName);
            EditText password=findViewById(R.id.editTextTextPassword);
            String sql="insert into users(name,pwd) values('"+username.getText()+"','"+password.getText()+"')";
            writeSql.execSQL(sql);
            writeSql.close();
        }
    }

}