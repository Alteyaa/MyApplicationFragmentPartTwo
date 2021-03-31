package com.example.myapplicationfragment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationfragment.R;


public class ChildFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "tag";

    private String mParam1;
    private String mParam2;


    private TextView btnBack;
    private TextView btnFinish;
    private TextView txtWelcome;
    private ViewPager viewPager;
    private Fragment parent;

    public static ChildFragment newInstance(TextFragment fragmentParent, String param2) {
        ChildFragment fragment = new ChildFragment();
        fragment.parent = fragmentParent;
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.fragment_child, container, false);

        btnBack = view.findViewById(R.id.btnBack);
        btnFinish = view.findViewById(R.id.btnFinish);
        viewPager = getActivity().findViewById(R.id.viewPager);
        txtWelcome  = view.findViewById(R.id.txtWelcome);
        if (mParam2 !=null){
            txtWelcome.setText(mParam2);
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             OnBoardingActivity activity = (OnBoardingActivity) getActivity();
             activity.showMain();
            }
        });
        return view;
    }
}