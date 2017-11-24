package com.demo.nestrecycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.nestrecycleviewdemo.R;
import com.demo.nestrecycleviewdemo.base.ListBaseAdapter;
import com.demo.nestrecycleviewdemo.bean.DataBean;
import com.demo.nestrecycleviewdemo.bean.SuperViewHolder;

/**
 * Created by liushu on 2017/11/24.
 */

public class OutAdapter extends ListBaseAdapter<DataBean.HistListBean> {


    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), null, false);
        return new SuperViewHolder(itemView);
    }

    public OutAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_out;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {

        DataBean.HistListBean histListBean = mDataList.get(position);
        TextView tvDay = holder.getView(R.id.tv_day);
        TextView tvMonth = holder.getView(R.id.tv_month);
        String newsFlashDate = histListBean.getDateStr();
        tvDay.setText(newsFlashDate.substring(newsFlashDate.length() - 2, newsFlashDate.length()) + "号");
        tvMonth.setText(newsFlashDate.substring(5, 7) + "月");
        RecyclerView recyclerView = holder.getView(R.id.recyclerview_inner);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new InnerAdapter(mContext, histListBean.getTranList(), position));
    }
}