package com.example.uzairzohaib.whatsaround;

/**
 * Created by UZAIR on 6/6/2018.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.MyViewHolder> {


    Context mContext;
    List<Profile> mData;

    public ProfileRecyclerViewAdapter(Context mContext, List<Profile> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.profile_recycler_view, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_txt.setText(mData.get(position).getName());
        holder.img_p.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_txt;
        private ImageView img_p;



        public MyViewHolder (View itemView) {
            super(itemView);

            tv_txt = (TextView) itemView.findViewById(R.id.profile_name);
            img_p = (ImageView) itemView.findViewById(R.id.img_profile);

        }
    }



}

