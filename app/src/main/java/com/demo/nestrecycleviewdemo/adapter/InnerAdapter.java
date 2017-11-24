package com.demo.nestrecycleviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.nestrecycleviewdemo.R;
import com.demo.nestrecycleviewdemo.base.ListBaseAdapter;
import com.demo.nestrecycleviewdemo.bean.DataBean;
import com.demo.nestrecycleviewdemo.bean.SuperViewHolder;

import java.util.List;

/**
 * Created by liushu on 2017/11/24.
 */

public class InnerAdapter extends ListBaseAdapter<DataBean.HistListBean.TranListBean> {


    public InnerAdapter(Context context, List<DataBean.HistListBean.TranListBean> list, int position) {
        super(context);
        setDataList(list);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_inner;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        DataBean.HistListBean.TranListBean tranListBean = mDataList.get(position);
        TextView tvDayTime = holder.getView(R.id.tv_day_time);
        tvDayTime.setText(tranListBean.getHourTime());
        final TextView tvContent = holder.getView(R.id.tv_content);
        tvContent.setText(tranListBean.getContentDetail());
        final boolean isShowAll = tranListBean.isIsShowAll();
        final LinearLayout llShowAll = holder.getView(R.id.ll_show_content);
        tvContent.post(new Runnable() {
            @Override
            public void run() {
                int txtPart = tvContent.getLineCount();

                if (txtPart < 3) {
                    llShowAll.setVisibility(View.GONE);
                } else {
                    llShowAll.setVisibility(View.VISIBLE);
                }

                if (!isShowAll && txtPart > 3) {
                    tvContent.setMaxLines(3);
                }
            }
        });
        TextView tvShow = holder.getView(R.id.tv_show);

        if (isShowAll) {
            tvShow.setText("关闭");
        } else {
            tvShow.setText("打开");
        }

        llShowAll.setTag(position);
        llShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                if (mDataList.get(position).isIsShowAll()) {
                    mDataList.get(position).setIsShowAll(false);
                } else {
                    mDataList.get(position).setIsShowAll(true);
                }
                refreshData(position);
            }
        });
    }

    private void refreshData(int position) {
        this.notifyItemChanged(position);
    }

}
