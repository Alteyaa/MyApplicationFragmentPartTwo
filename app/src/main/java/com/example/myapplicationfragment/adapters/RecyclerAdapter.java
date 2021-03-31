package com.example.myapplicationfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationfragment.ui.IFragment;
import com.example.myapplicationfragment.R;
import com.example.myapplicationfragment.model.RecyclerModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<RecyclerModel> list;

    private Context context;
    private IFragment listener;

    public RecyclerAdapter(ArrayList<RecyclerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
      holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView txtTitle;
        private TextView subTitle;
        private RecyclerModel model;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            subTitle = itemView.findViewById(R.id.txtSubTitle);
        }

        private void onBind(RecyclerModel model){
            this.model = model;
            txtTitle.setText(model.getTitle());
            subTitle.setText(model.getSubTitle());
        }

        @Override
        public void onClick(View v) {
            if (listener !=null){
                listener.displayDetails(model.getTitle(),model.getSubTitle());
            }
        }
    }
    public void setOnclickListener(IFragment mListener){
        this.listener = mListener;
    }
}
