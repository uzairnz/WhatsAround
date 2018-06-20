package com.example.uzairzohaib.whatsaround;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

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
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_category.setText(mData.get(position).getCategory());
        holder.tv_location.setText(mData.get(position).getLocation());
//        holder.img.setImageResource(mData.get(position).getPhoto());
        //for quotes
  //    holder.quote_id.setText(mData2.get(position).getId());
   //   holder.quote_price.setText(mData2.get(position).getPrice());

//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on: " + mData2.get(position));
//
//                Toast.makeText(mContext, "Clicked on " + mData2.get(position).getId(), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(mContext, Quote_Detail.class);
//                intent.putExtra("quote_Price", mData2.get(position).getPrice());
//                intent.putExtra("quote_Id", mData2.get(position).getId());
//                mContext.startActivity(intent);
//            }
//        });

    }



    @Override
    public int getItemCount() { return mData.size();}     // for array list 1




    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_category;
        private TextView tv_location;
        private ImageView img;
        RelativeLayout parentLayout;
        //Quotes
        private TextView quote_id;
        private TextView quote_price;
        private TextView quote_description;



        public MyViewHolder (View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.quote_name);
            tv_category = (TextView) itemView.findViewById(R.id.quote_category);
            tv_location = (TextView) itemView.findViewById(R.id.quote_location);
            img = (ImageView) itemView.findViewById(R.id.img_quote);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            quote_id = (TextView) itemView.findViewById(R.id.quote_Id);
            quote_price = (TextView) itemView.findViewById(R.id.quote_price);


        }
    }



}

