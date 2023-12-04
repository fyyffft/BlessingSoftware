package com.software;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.software.RecommendPage.RecommendYueQiListAdapter;
import com.software.RecommendPage.RecommendYueQuAdapter;
import com.software.RecommendPage.YueQi;
import com.software.RecommendPage.YueQu;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

//Created by ws  页面3热门推荐控件
public class Recommendations_Fragment extends Fragment {
    private Banner banner;
    private List<Integer> bannerData;
    private Bitmap bitmap;
    private RecyclerView yueQiRecyclerView,yueQuRecycleView;
    ArrayList<YueQi> yueQiList = new ArrayList<>();
    List<YueQu> yueQuList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View recommendations =inflater.inflate(R.layout.recommendations_page,null);

//        //调整图片大小
//        bitmap = setImage(R.mipmap.yueqi_ruanxian, 400,400);

//        1.实现轮播图

        //1.1准备数据源
        initLunBoTuData();
        //1.2绑定控件
        banner = recommendations.findViewById(R.id.main_banner);
        //1.3绑定adapter
        setAdapter();
        //1.4实现点击事件
        setBannerListen();

//        2.实现乐器列表横向滚动

        //2.1.准备数据源
        initYueQiListData();
        //2.2.绑定控件
        yueQiRecyclerView = recommendations.findViewById(R.id.yueQi_recyclerview);
        //2.3.绑定adapter
        yueQiRecyclerView.setAdapter(new RecommendYueQiListAdapter(this.getContext(),yueQiList));
        //2.4.调用RecycleView方法
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);//横向滚动方法
        yueQiRecyclerView.setLayoutManager(layoutManager);

//      3.卡片布局实现乐曲列表

        //3.1.准备数据源
        initYueQuListData();
        //2.2.绑定控件
        yueQuRecycleView = recommendations.findViewById(R.id.yueQu_recyclerview);

        //2.3.绑定adapter
        yueQuRecycleView.setAdapter(new RecommendYueQuAdapter(this.getContext(),yueQuList));
        //2.4.调用GridLayoutManager方法实现一行两个的布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2);
        yueQuRecycleView.setLayoutManager(gridLayoutManager);


        return recommendations;
    }


//    private Bitmap setImage(int resId, int width, int height) {
//        Resources res = this.getResources();
//        Bitmap oldSize = BitmapFactory.decodeResource(res,resId);
//        Bitmap newSize = Bitmap.createScaledBitmap(oldSize,width,height,true);
//        return newSize;
//    }

    private void setBannerListen() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object data, int position) {
                Toast.makeText(getActivity(),
                        "you clicked "+position,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    private void initYueQuListData() {

        YueQu y1 = new YueQu();
        y1.setName("十面埋伏");
        y1.setImage(R.mipmap.yuequ01);
        yueQuList.add(y1);
        YueQu y2 = new YueQu();
        y2.setName("夕阳箫鼓");
        y2.setImage(R.mipmap.yuequ02);
        yueQuList.add(y2);
        YueQu y3 = new YueQu();
        y3.setName("平沙落雁");
        y3.setImage(R.mipmap.yuequ03);
        yueQuList.add(y3);
        YueQu y4 = new YueQu();
        y4.setName("广陵散");
        y4.setImage(R.mipmap.yuequ04);
        yueQuList.add(y4);
        YueQu y5 = new YueQu();
        y5.setName("胡茄十八拍");
        y5.setImage(R.mipmap.yuequ05);
        yueQuList.add(y5);
        YueQu y6 = new YueQu();
        y6.setName("高山流水");
        y6.setImage(R.mipmap.yuequ06);
        yueQuList.add(y6);

    }

    private void initYueQiListData() {
        YueQi y1 = new YueQi();
        y1.setyName("阮咸");
        y1.setyImage(R.mipmap.yueqi_ruanxian);
        yueQiList.add(y1);
        YueQi y2 = new YueQi();
        y2.setyName("二胡");
        y2.setyImage(R.mipmap.yueqi_erhu);
        yueQiList.add(y2);
        YueQi y3 = new YueQi();
        y3.setyName("古琴");
        y3.setyImage(R.mipmap.yueqi_guqin);
        yueQiList.add(y3);
        YueQi y4 = new YueQi();
        y4.setyName("古筝");
        y4.setyImage(R.mipmap.yueqi_guzheng);
        yueQiList.add(y4);
        YueQi y5 = new YueQi();
        y5.setyName("箜篌");
        y5.setyImage(R.mipmap.yueqi_konghou);
        yueQiList.add(y5);
        YueQi y6 = new YueQi();
        y6.setyName("琵琶");
        y6.setyImage(R.mipmap.yueqi_pipa);
        yueQiList.add(y6);

    }

    private void initLunBoTuData() {
        bannerData = new ArrayList<>();
        bannerData.add(R.mipmap.lunbo001);
        bannerData.add(R.mipmap.lunbo002);
        bannerData.add(R.mipmap.lunbo003);
//        bannerData.add(R.mipmap.a4);

    }

    private void setAdapter() {
        banner.setAdapter(new BannerImageAdapter<Integer>(bannerData) {

            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });
        banner.isAutoLoop(true);
        banner.setIndicator(new CircleIndicator(this.getContext()));
        banner.setScrollBarFadeDuration(1000);
        banner.setIndicatorSelectedColor(Color.GREEN);
        banner.start();

    }

}