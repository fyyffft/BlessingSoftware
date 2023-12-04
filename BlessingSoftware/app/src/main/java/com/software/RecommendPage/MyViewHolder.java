package com.software.RecommendPage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.software.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView yqName,yueQuName;
    public ImageView yqImage,yueQuImage;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        yqName = itemView.findViewById(R.id.tv_yueQi_name);
        yqImage = itemView.findViewById(R.id.iv_yueQi);
        yueQuName = itemView.findViewById(R.id.tv_yueQu_name);
        yueQuImage = itemView.findViewById(R.id.iv_yueQu);
    }
}
