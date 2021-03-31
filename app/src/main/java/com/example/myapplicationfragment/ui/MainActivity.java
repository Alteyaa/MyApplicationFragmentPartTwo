package com.example.myapplicationfragment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.myapplicationfragment.R;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    public static final String KEY = "key";
    public static final String KEY2 = "key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        if (intent != null) {
            String title = intent.getStringExtra(ApplicationActivity.KEy_TITLE);
            String subTitle = intent.getStringExtra(ApplicationActivity.KEy_SUBTITLE);

            fragmentManager = getSupportFragmentManager();

            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first,ChangeFragment.newInstance(title,subTitle));
            transaction.commit();
        }
    }
    public void displayDetails(String title, String subTitle) {

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            TextFragment fragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragment_second);
            transaction = fragmentManager.beginTransaction();
            fragment.showText(title,subTitle);
            transaction.commit();
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY, title);
            intent.putExtra(KEY2, subTitle);
            startActivity(intent);
        }
    }

}