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
import com.example.uzairzohaib.whatsaround.models.Book;
import com.example.uzairzohaib.whatsaround.models.Service;

import java.util.ArrayList;

import static org.greenrobot.eventbus.EventBus.TAG;

/**
 * Created by UZAIR on 7/30/2018.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Book> mData;

    public BookingAdapter(Context mContext, ArrayList<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }
    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.booking_recyclerview, parent, false);
        BookingAdapter.MyViewHolder viewHolder = new BookingAdapter.MyViewHolder(v);
        return viewHolder;
    }
    public void changeset(ArrayList<Book> mData){
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(BookingAdapter.MyViewHolder holder, final int position) {

        holder.tv_booking_id.setText(mData.get(position).getBs_id());
        holder.tv_status.setText(mData.get(position).getStatus());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mData.get(position));

//                Toast.makeText(mContext, "Clicked on " + mData.get(position).getId(), Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(mContext, SearchDetail.class);
//                intent.putExtra("service_Id", mData.get(position).getId());
             //   mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_booking_id;
        private TextView tv_service_name;
        private TextView tv_partner_name;
        private TextView tv_status;
        private RelativeLayout relativeLayout;


        public MyViewHolder(View itemView) {
            super(itemView);

//            tv_booking_id = (TextView) itemView.findViewById(R.id.booking_id);
//            tv_service_name = (TextView) itemView.findViewById(R.id.service_name);
//            tv_partner_name = (TextView) itemView.findViewById(R.id.Partner_Name);
            tv_status = (TextView) itemView.findViewById(R.id.book_status);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.book_parent_layout);

        }
    }
}
