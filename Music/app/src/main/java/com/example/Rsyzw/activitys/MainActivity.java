package com.example.Rsyzw.activitys;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Rsyzw.R;
import com.example.Rsyzw.adapters.MusicBlockAdapter;
import com.example.Rsyzw.adapters.MusicGridAdapter;
import com.example.Rsyzw.adapters.MusicListAdapter;
import com.example.Rsyzw.adapters.MusicRecordAdapter;
import com.example.Rsyzw.helps.RealmHelper;
import com.example.Rsyzw.models.MusicSourceModel;
import com.example.Rsyzw.utils.ImagesUtil;
import com.example.Rsyzw.views.GridSpaceItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    //轮播图
    private Banner mBanner;
    //轮播图图片数据及标题
    private ArrayList<String> images;
    private ArrayList<String> imageTitle;

    //四个列表
    private RecyclerView  mRvBlock,mRvGrid, mRvAlbum, mRvList;
    //一种数据库，存储歌曲
    private RealmHelper mRealmHelper;
    private MusicSourceModel mMusicSourceModel;
    //每日推荐板块
    private String[] blockTitle = {"每日推荐","歌单","排行榜","电台","直播"};
    private int[] blockImage = {R.mipmap.love,R.mipmap.album,R.mipmap.rank,R.mipmap.radio,R.mipmap.onlive};

    //数据适配器
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;
    private MusicBlockAdapter mBlockAdapter;
    private MusicRecordAdapter mRecordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBanner = fd(R.id.banner);

        initData();

        initView();
    }

    private void initData() {
        images = ImagesUtil.getBitMapUrl();
        imageTitle = ImagesUtil.getBitMapTitleUrl();

        mRealmHelper = new RealmHelper();
        mMusicSourceModel = mRealmHelper.getMusicSource();
    }

    private void initView () {
        initNavBar(false, "送给最好的她", true);
        //设置banner样式 显示圆形指示器和标题
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(imageTitle);
        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置是否允许手动滑动轮播图
        mBanner.setViewPagerIsScroll(true);
        //设置是否自动轮播（不设置则默认自动）
        mBanner.isAutoPlay(true);
        //设置轮播图片间隔时间（不设置默认为2000）
        mBanner.setDelayTime(1500);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        mBanner.setImages(images)
            .setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(MainActivity.this, "你点了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();
                }
            })
            .start();

        // 四个版块
        //每日推荐、歌单、排行榜、电台、直播
        mRvBlock = fd(R.id.rv_block);
        //设置布局管理器
        mRvBlock.setLayoutManager(new GridLayoutManager(this, blockTitle.length));
        //添加分割线
        mRvBlock.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvBlock));
        mRvBlock.setNestedScrollingEnabled(false); //取消滑动
        //添加适配器对数据进行适配
        mBlockAdapter = new MusicBlockAdapter(this, blockTitle, blockImage);
        mRvBlock.setAdapter(mBlockAdapter);

        // 推荐歌单
        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false); //取消滑动
        mGridAdapter = new MusicGridAdapter(this, mMusicSourceModel.getAlbum());
        mRvGrid.setAdapter(mGridAdapter);

        // 新增专辑列表（新碟）
        mRvAlbum = fd(R.id.rv_album);
        mRvAlbum.setLayoutManager(new GridLayoutManager(this, 3));
        mRvAlbum.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvAlbum));
        mRvAlbum.setNestedScrollingEnabled(false); //取消滑动
        mRecordAdapter = new MusicRecordAdapter(this, mMusicSourceModel.getPlayList());
        mRvAlbum.setAdapter(mRecordAdapter);

        /**
         * 1、假如已知列表高度的情况下，可以直接在布局中把RecyclerView的高度定义上
         * 2、不知道列表高度的情况下，需要手动计算RecyclerView的高度
         */
        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mListAdapter = new MusicListAdapter(this, mRvList, mMusicSourceModel.getHot());
        mRvList.setAdapter(mListAdapter);
    }

    /**
     * 网络加载图片
     * 使用了Glide图片加载框架
     */
    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context)
                    .load((String) path)
//                    .transform(new GlideRectRound(RankActivity.this))
                    .into(imageView);
        }

    }


    @Override
    protected void onDestroy() {
//        if(isLiving) return;
        super.onDestroy();
        mRealmHelper.close();
    }

}
