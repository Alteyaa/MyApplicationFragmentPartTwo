package com.example.myapplicationfragment.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplicationfragment.R;
import com.example.myapplicationfragment.adapters.RecyclerAdapter;
import com.example.myapplicationfragment.model.RecyclerModel;

import java.util.ArrayList;


public class ChangeFragment extends Fragment implements IFragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private IFragment iFragment;
    private ArrayList<RecyclerModel> list;
    private RecyclerAdapter adapter;

    public ChangeFragment() {
    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
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

        View view = inflater.inflate(R.layout.fragment_change, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {

        list = new ArrayList<>();

        list.add(new RecyclerModel(mParam1,mParam2));
        list.add(new RecyclerModel(mParam1,mParam2));
        list.add(new RecyclerModel(mParam1,mParam2));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list,requireContext());
        adapter.setOnclickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String subTitle) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title,subTitle);
    }
}