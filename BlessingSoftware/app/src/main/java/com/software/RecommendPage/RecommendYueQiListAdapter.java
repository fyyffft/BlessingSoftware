package com.software.RecommendPage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.software.R;

import java.util.ArrayList;

public class RecommendYueQiListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private View view;
    private ArrayList<YueQi> yueQiList;

    public RecommendYueQiListAdapter(Context context,ArrayList<YueQi> yueQiList){
        this.context = context;
        this.yueQiList = yueQiList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.recommend_yueqi_list, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.yqName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        "you clicked "+myViewHolder.yqName.getText(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        myViewHolder.yqImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,InstrumentDetailsActivity.class);
                context.startActivity(intent);
                Toast.makeText(context,
                        "you clicked "+myViewHolder.yqImage.getImageMatrix(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YueQi yueqi = yueQiList.get(position);
        holder.yqName.setText(yueqi.getyName());
        //高效加载图片
        Glide.with(context).load(yueqi.getyImage()).into(holder.yqImage);
//        holder.yqImage.setImageResource(yueqi.getyImage());
    }

    @Override
    public int getItemCount() {
        return yueQiList.size();
    }
}
