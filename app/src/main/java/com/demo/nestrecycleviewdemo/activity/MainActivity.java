package com.demo.nestrecycleviewdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.nestrecycleviewdemo.R;
import com.demo.nestrecycleviewdemo.adapter.OutAdapter;
import com.demo.nestrecycleviewdemo.bean.DataBean;
import com.demo.nestrecycleviewdemo.utils.FileUtil;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.lrv_list)
    LRecyclerView mLrvList;
    @Bind(R.id.tv_day)
    TextView mTvDay;
    @Bind(R.id.tv_month)
    TextView mTvMonth;
    @Bind(R.id.ll_title)
    LinearLayout mLlTitle;

    private OutAdapter mOutAdapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    private int pageNumber;
    private int pageSize;
    private LinearLayoutManager mLayoutManager;
    private int mCurrentPosition = 0;
    private int mTitleHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        pageNumber = 1;
        pageSize = 10;
        mLrvList.setNestedScrollingEnabled(false);
        mOutAdapter = new OutAdapter(this);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mOutAdapter);
        mLrvList.setAdapter(mLRecyclerViewAdapter);
        mLRecyclerViewAdapter.removeFooterView();
        mLrvList.setPullRefreshEnabled(true);
        initDivider();
        initRefreshLoadListener();
        initScrollListener();
        query();
    }

    private void initScrollListener() {
        mLrvList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mTitleHeight = mLlTitle.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = mLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view != null) {
                    if (view.getTop() <= mTitleHeight) {
                        mLlTitle.setY(-(mTitleHeight - view.getTop()));
                    } else {
                        mLlTitle.setY(0);
                    }
                }
                if (mCurrentPosition != mLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = mLayoutManager.findFirstVisibleItemPosition();
                    mLlTitle.setY(0);
                    updateTitleData();
                }
            }
        });
    }

    private void updateTitleData() {
        if (mCurrentPosition > 0) {
            mLlTitle.setVisibility(View.VISIBLE);
            String newsFlashDate = mOutAdapter.getDataList().get(mCurrentPosition - 1).getDateStr();
            mTvMonth.setText(newsFlashDate.substring(5, 7) + "月");
            mTvDay.setText(newsFlashDate.substring(newsFlashDate.length() - 2, newsFlashDate.length()) + "号");
        } else {
            mLlTitle.setVisibility(View.INVISIBLE);
        }
    }

    private void initDivider() {
        mLayoutManager = new LinearLayoutManager(this) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mLrvList.setLayoutManager(mLayoutManager);
        mLrvList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mLrvList.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
    }

    private void initRefreshLoadListener() {
        mLrvList.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pageNumber = 1;
                        mOutAdapter.clear();
                        query();
                    }
                }, 300);

            }
        });
        mLrvList.setLoadMoreEnabled(true);
        mLrvList.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                pageNumber++;
                query();
            }
        });
    }

    private void query() {
        String s = FileUtil.readFromAssets(this, "test11.json");
        Gson gson = new Gson();
        final DataBean bean = gson.fromJson(s, DataBean.class);
        mOutAdapter.addAll(bean.getHistList());
        mOutAdapter.notifyDataSetChanged();
        mLRecyclerViewAdapter.notifyDataSetChanged();
        mLrvList.refreshComplete(10);
    }


}
