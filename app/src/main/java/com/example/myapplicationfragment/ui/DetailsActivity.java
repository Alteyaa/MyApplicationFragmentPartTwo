package com.example.myapplicationfragment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplicationfragment.R;

public class DetailsActivity extends AppCompatActivity {


    private String title;
    private String subTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent !=null){
            title = intent.getStringExtra(MainActivity.KEY);
            subTitle = intent.getStringExtra(MainActivity.KEY2);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TextFragment fragment = TextFragment.newInstance(title,subTitle);
        transaction.add(R.id.details_fragment,fragment);
        transaction.commit();
    }
}