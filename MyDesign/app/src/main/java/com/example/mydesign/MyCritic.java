package com.example.mydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydesign.dataBase.MySqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class MyCritic extends AppCompatActivity {
    List<Bean> data =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_critic);
        final CurrentUser currentUser=(CurrentUser)getApplication();
        TextView tv=findViewById(R.id.textView3);
        tv.setText(currentUser.getText());
    }
    public void Init(){
        data.clear();
        SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
        SQLiteDatabase readSql=sqLiteOpenHelper.getReadableDatabase();
        final CurrentUser currentUser=(CurrentUser)getApplication();
        String sql="select * from question where name=? and question= ? and critic is not null";
        Cursor cursor=readSql.rawQuery(sql,new String[]{currentUser.getUsername(),currentUser.getText()});
        if(cursor.getCount()!=0){
            ListView lvc=findViewById(R.id.lvc);
            while (cursor.moveToNext()){
                String question=cursor.getString(cursor.getColumnIndex("critic"));
                data.add(new Bean(question));
            }
            lvc.setAdapter(new MyAdapter(data,this));
        }
        cursor.close();
        readSql.close();
    }
    public void InsertCritic(View view) {
        EditText critic=findViewById(R.id.editTextTextCritic);
        if(!critic.getText().toString().isEmpty()){
            SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
            SQLiteDatabase writeSql=sqLiteOpenHelper.getWritableDatabase();
            final CurrentUser currentUser=(CurrentUser)getApplication();
            String sql="insert into question(name,question,critic)values('"+currentUser.getUsername()+"','"+currentUser.getText()+"','"+critic.getText().toString()+"')";
            writeSql.execSQL(sql);
            writeSql.close();
            Toast.makeText(this,"the comment was added successfully!",Toast.LENGTH_LONG).show();
            Init();
        }else{
            Toast.makeText(this,"Please enter a comment!",Toast.LENGTH_LONG).show();
        }
    }
}