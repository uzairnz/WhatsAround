package com.example.uzairzohaib.whatsaround.adapters;

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

import com.example.uzairzohaib.whatsaround.Quote_Detail;
import com.example.uzairzohaib.whatsaround.R;
import com.example.uzairzohaib.whatsaround.models.Service;
import com.example.uzairzohaib.whatsaround.models.ServiceQuote;

import java.util.ArrayList;
import java.util.List;

import static org.greenrobot.eventbus.EventBus.TAG;

/**
 * Created by UZAIR on 6/9/2018.
 */

public class QuoteRecyclerViewAdapter extends RecyclerView.Adapter<QuoteRecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    ArrayList<ServiceQuote> mData;


    public QuoteRecyclerViewAdapter(Context mContext, ArrayList<ServiceQuote> mData) {
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

    public void changeset(ArrayList<ServiceQuote> mData){
        this.mData = mData;
        this.notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        ServiceQuote serviceQuote = mData.get(position);

        holder.tv_name.setText(serviceQuote.getService_Name());
        holder.tv_category.setText(serviceQuote.getCategory());
        holder.tv_location.setText(serviceQuote.getLocation());
//        holder.img.setImageResource(mData.get(position).getPhoto());
        //for quotes
      holder.quote_id.setText(serviceQuote.getQuote_Id());
      holder.quote_price.setText(serviceQuote.getPrice());
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on: " + mData.get(position));
//
//                Toast.makeText(mContext, "Clicked on " + mData.get(position).getService_Id(), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(mContext, Quote_Detail.class);
//                intent.putExtra("service_Id", mData.get(position).getService_Id());
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

