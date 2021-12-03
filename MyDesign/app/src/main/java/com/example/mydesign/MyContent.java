package com.example.mydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mydesign.dataBase.MySqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class MyContent extends AppCompatActivity {
    List<Bean> data =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_content);
        Init();
    }
    public void Init(){
        data.clear();
        Intent it=new Intent(this,MyCritic.class);
        SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
        SQLiteDatabase readSql=sqLiteOpenHelper.getReadableDatabase();
        final CurrentUser currentUser=(CurrentUser)getApplication();
        String sql="select * from question where name='"+currentUser.getUsername()+"' and critic is null";
        Cursor cursor=readSql.rawQuery(sql,null);
        if(cursor.getCount()!=0){
            ListView lv=findViewById(R.id.lv);
            while (cursor.moveToNext()){
                String question=cursor.getString(cursor.getColumnIndex("question"));
                data.add(new Bean(question));
            }
            lv.setAdapter(new MyAdapter(data,this));
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final CurrentUser currentUser=(CurrentUser)getApplication();
                    currentUser.setPosition(position);
                    currentUser.setText(data.get(position).getReview());
                    startActivity(it);
                }
            });
        }
        cursor.close();
        readSql.close();
    }
    public void InsertQuestion(View view) {
        EditText question=findViewById(R.id.editTextTextQuestion);
        if(!question.getText().toString().isEmpty()){
            SQLiteOpenHelper sqLiteOpenHelper= MySqliteHelper.getSqLiteOpenHelper(this);
            SQLiteDatabase writeSql=sqLiteOpenHelper.getWritableDatabase();
            final CurrentUser currentUser=(CurrentUser)getApplication();
            String sql="insert into question(name,question,critic)values('"+currentUser.getUsername()+"','"+question.getText().toString()+"',null)";
            writeSql.execSQL(sql);
            writeSql.close();
            Toast.makeText(this,"The problem was added successfully!",Toast.LENGTH_LONG).show();
            Init();
        }else{
            Toast.makeText(this,"Please enter the question",Toast.LENGTH_LONG).show();
        }


    }
}