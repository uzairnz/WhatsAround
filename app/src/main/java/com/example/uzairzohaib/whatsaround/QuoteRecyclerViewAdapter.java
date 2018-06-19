package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UZAIR on 6/9/2018.
 */

public class QuoteRecyclerViewAdapter extends RecyclerView.Adapter<QuoteRecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    List<Service> mData;

    public QuoteRecyclerViewAdapter(Context mContext, List<Service> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.quotes_recyclerview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    public void changeset(ArrayList<Service> mData){
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_category.setText(mData.get(position).getCategory());
        holder.tv_location.setText(mData.get(position).getLocation());
//        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_category;
        private TextView tv_location;
        private ImageView img;



        public MyViewHolder (View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.quote_name);
            tv_category = (TextView) itemView.findViewById(R.id.quote_category);
            tv_location = (TextView) itemView.findViewById(R.id.quote_location);
            img = (ImageView) itemView.findViewById(R.id.img_quote);

        }
    }



}

