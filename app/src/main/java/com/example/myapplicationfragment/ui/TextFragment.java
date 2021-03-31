package com.example.myapplicationfragment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationfragment.R;


public class TextFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView txtTitle;
    private TextView txtSubTitle;

    private Handler handler;

    public TextFragment() {
    }

    public static TextFragment newInstance(String param1, String param2) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text, container, false);
        txtTitle = view.findViewById(R.id.title_text);
        txtSubTitle = view.findViewById(R.id.subTitle);

        if (mParam1 != null) {
            txtTitle.setText(mParam1);
            txtSubTitle.setText(mParam2);
        }
        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChildFragment(ChildFragment.
                        newInstance(TextFragment.this,"Hello from Parent"),ChildFragment.TAG);
            }
        });

        return view;
    }



    public void showText(String text, String description) {
        if (text != null) {
            txtTitle.setText(text);
            txtSubTitle.setText(description);
            Log.d("TAG",text);
        }
    }

    public void showChildFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout,fragment,tag);
        transaction.commit();
    }
}