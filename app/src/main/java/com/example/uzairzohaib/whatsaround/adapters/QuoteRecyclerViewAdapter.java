package com.example.uzairzohaib.whatsaround.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uzairzohaib.whatsaround.AddQuoteActivity;
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
    ArrayList<Service> mData;


    public QuoteRecyclerViewAdapter(Context mContext, ArrayList<Service> mData) {
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

        Service service = mData.get(position);
        holder.service_name.setText(mData.get(position).getName());
        holder.service_category.setText(mData.get(position).getCategory());
        holder.service_location.setText(mData.get(position).getLocation());

//        holder.img.setImageResource(mData.get(position).getPhoto());
        //for quotes


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mData.get(position));

                Toast.makeText(mContext, "Clicked on " + mData.get(position).getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, AddQuoteActivity.class);
                intent.putExtra("service_Id", mData.get(position).getId());

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { return mData.size();}     // for array list 1


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        RelativeLayout parentLayout;
        //Quotes
        private TextView service_name;
        private TextView service_category;
        private TextView service_location;


        public MyViewHolder (View itemView) {
            super(itemView);

           img = (ImageView) itemView.findViewById(R.id.img_quote);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            service_name = (TextView)itemView.findViewById(R.id.quote_name);
            service_category= (TextView)itemView.findViewById(R.id.quote_category);
            service_location = (TextView)itemView.findViewById(R.id.quote_location);

        }
    }



}

