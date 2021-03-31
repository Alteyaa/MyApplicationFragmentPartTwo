package com.example.myapplicationfragment.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplicationfragment.R;

public class ApplicationActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etSubTitle;
    private Button btnSave;

    public static final String KEy_TITLE = "title";
    public static final String KEy_SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        init();
    }

    private void init() {
        etTitle = findViewById(R.id.etTitle);
        etSubTitle = findViewById(R.id.etSubTitle);
        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String subTitle = etSubTitle.getText().toString();
                Intent intent = new Intent(ApplicationActivity.this,MainActivity.class);
                intent.putExtra(KEy_TITLE,title);
                intent.putExtra(KEy_SUBTITLE,subTitle);
                startActivity(intent);
                finish();
            }
        });
    }
}