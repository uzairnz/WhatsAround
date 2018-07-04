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

import com.example.uzairzohaib.whatsaround.R;
import com.example.uzairzohaib.whatsaround.SearchDetail;
import com.example.uzairzohaib.whatsaround.models.Service;

import java.util.ArrayList;

import static org.greenrobot.eventbus.EventBus.TAG;

/**
 * Created by UZAIR&ZOHAIB on 4/12/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    ArrayList<Service> mData;

    public RecyclerViewAdapter(Context mContext, ArrayList<Service> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.services_recyclerview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }
    public void changeset(ArrayList<Service> mData){
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

       holder.tv_name.setText(mData.get(position).getName());
       holder.tv_category.setText(mData.get(position).getCategory());
       holder.tv_location.setText(mData.get(position).getLocation());
//       holder.img.setImageResource(mData.get(position).getPhoto());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mData.get(position));

                Toast.makeText(mContext, "Clicked on " + mData.get(position).getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, SearchDetail.class);
                intent.putExtra("service_Id", mData.get(position).getId());
                mContext.startActivity(intent);
            }
        });

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
        private RelativeLayout relativeLayout;



        public MyViewHolder (View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.service_name);
            tv_category = (TextView) itemView.findViewById(R.id.service_category);
            tv_location = (TextView) itemView.findViewById(R.id.service_location);
            img = (ImageView) itemView.findViewById(R.id.img_service);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.search_parent_layout);

        }
    }



}
