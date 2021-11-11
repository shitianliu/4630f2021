package com.example.assignment4new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText username;
        private EditText password;
        private Button button_login;
        private Button button enroll;
        private String str_username;
        private String str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        enroll=findViewById(R.id.enroll);

    }

}
