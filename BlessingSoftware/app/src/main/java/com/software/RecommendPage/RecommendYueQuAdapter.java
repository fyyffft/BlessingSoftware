package com.software.RecommendPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.software.R;

import java.util.List;

public class RecommendYueQuAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<YueQu> yueQuList;
    private View view;
    public RecommendYueQuAdapter(Context context,List<YueQu> yueQuList){
        this.context = context;
        this.yueQuList = yueQuList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.recommend_yuequ_cardlist,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.yueQuName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        "you clicked "+myViewHolder.yueQuName.getText(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        myViewHolder.yueQuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        "you clicked "+myViewHolder.yueQuImage.getImageAlpha(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        YueQu yueQu = yueQuList.get(position);
        holder.yueQuName.setText(yueQu.getName());
        Glide.with(context).load(yueQu.getImage()).into(holder.yueQuImage);
    }

    @Override
    public int getItemCount() {
        return yueQuList.size();
    }
}
