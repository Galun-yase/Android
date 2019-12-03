package com.example.Rsyzw.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.Rsyzw.R;
import com.example.Rsyzw.fragment.DayRankFragment;
import com.example.Rsyzw.fragment.MonthRankFragment;
import com.example.Rsyzw.fragment.WeekRankFragment;
import com.example.Rsyzw.fragment.YearRankFragment;

import java.util.ArrayList;
import java.util.List;

public class RankActivity extends FragmentActivity implements OnClickListener {
    //声明ViewPager
    private ViewPager mViewPager;
    //适配器
    private FragmentPagerAdapter mAdapter;
//    //装载Fragment的集合
    private List<Fragment> mFragments;

//    ViewPager viewPager;

    //四个Tab对应的布局
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    //四个Tab对应的ImageButton
    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;

    private ImageView mIvBack, mIvMe;
    private TextView mIvTitle;

    private RecyclerView mRvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.rank);

        initViews();//初始化控件
        initEvents();//初始化事件
        initDatas();//初始化数据
    }

    //初始化控件
    private void initViews() {
        //初始化navBar...
        BaseActivity baseActivity = new BaseActivity();
        mIvBack = findViewById(R.id.iv_back);
        mIvTitle = findViewById(R.id.tv_title);
        mIvMe = findViewById(R.id.iv_me);
        if (!this.isFinishing()){
            baseActivity.initNavBar2(true, "音乐榜", true,
                    mIvBack, mIvTitle, mIvMe, this);
        }

        mViewPager = findViewById(R.id.id_viewpager);

        mTabWeixin = findViewById(R.id.id_tab_weixin);
        mTabFrd = findViewById(R.id.id_tab_frd);
        mTabAddress = findViewById(R.id.id_tab_address);
        mTabSetting = findViewById(R.id.id_tab_setting);

        mImgWeixin = findViewById(R.id.id_tab_weixin_img);
        mImgFrd = findViewById(R.id.id_tab_frd_img);
        mImgAddress = findViewById(R.id.id_tab_address_img);
        mImgSetting = findViewById(R.id.id_tab_setting_img);

        //排行榜tab的歌单list
    }

    private void initDatas() {

        mFragments = new ArrayList<>();

        mFragments.add(new DayRankFragment(this));
        mFragments.add(new WeekRankFragment(this));
        mFragments.add(new MonthRankFragment(this));
        mFragments.add(new YearRankFragment(this));

//        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };

        //不要忘记设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvents() {
        //设置四个Tab的点击事件
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //先将四个ImageButton置为灰色
        resetImgs();

        //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                selectTab(0);
                break;
            case R.id.id_tab_frd:
                selectTab(1);
                break;
            case R.id.id_tab_address:
                selectTab(2);
                break;
            case R.id.id_tab_setting:
                selectTab(3);
                break;
        }
    }

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mImgWeixin.setImageResource(R.mipmap.rank2);
                break;
            case 1:
                mImgFrd.setImageResource(R.mipmap.rank2);
                break;
            case 2:
                mImgAddress.setImageResource(R.mipmap.rank2);
                break;
            case 3:
                mImgSetting.setImageResource(R.mipmap.rank2);
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    //将四个ImageButton设置为灰色
    private void resetImgs() {
        mImgWeixin.setImageResource(R.mipmap.day);
        mImgFrd.setImageResource(R.mipmap.week);
        mImgAddress.setImageResource(R.mipmap.month);
        mImgSetting.setImageResource(R.mipmap.year);
    }
}
