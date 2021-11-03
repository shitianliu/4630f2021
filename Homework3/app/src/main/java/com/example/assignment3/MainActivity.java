package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button weather_around_me;
    Button fact_about;
    Button investment_portfolio;
    Button my_resume;
    Button other_facts_about_me;
    Button somethin_else;
    Button assignment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather_around_me = (Button) findViewById(R.id.button);
        weather_around_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        fact_about = (Button) findViewById(R.id.button2);
        fact_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
        investment_portfolio = (Button) findViewById(R.id.button4);
        investment_portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity4();
            }
        });
        my_resume = (Button) findViewById(R.id.button5);
        my_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity5();
            }
        });
        other_facts_about_me = (Button) findViewById(R.id.button6);
        other_facts_about_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity6();
            }
        });
        somethin_else = (Button) findViewById(R.id.button7);
        somethin_else.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity7();
            }
        });
        assignment2 = (Button) findViewById(R.id.button8);
        assignment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity8();
            }
        });

    }
    public void openNewActivity() {
        Intent intent = new Intent(this, Weather_Around_Me_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity2() {
        Intent intent = new Intent(this, Fact_About_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity4() {
        Intent intent = new Intent(this, Investment_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity5() {
        Intent intent = new Intent(this, Resume_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity6() {
        Intent intent = new Intent(this, Other_Fact_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity7() {
        Intent intent = new Intent(this, Something_Else_Activity.class);
        startActivity(intent);
    }
    public void openNewActivity8() {
        Intent intent = new Intent(this, Assgnment2_Activity.class);
        startActivity(intent);
    }
}