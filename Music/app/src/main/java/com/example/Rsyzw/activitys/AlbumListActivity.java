package com.example.Rsyzw.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.Rsyzw.R;
import com.example.Rsyzw.adapters.MusicListAdapter;
import com.example.Rsyzw.helps.RealmHelper;
import com.example.Rsyzw.models.AlbumModel;
import com.example.Rsyzw.models.PlayListModel;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class AlbumListActivity extends BaseActivity {

    public static final String IS_ALBUM = "album";
    public static final String IS_PLAYLIST = "playList";
    private boolean isAlbum;
    private boolean isPlayList;

    public static final String ALBUM_ID = "albumId";
    public static final String PLAYLIST_ID = "playListId";
    public static final String MUSIC_ID = "musicId";

    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    private ImageView bg_icon, iv_icon;
    private TextView al_title, tv_info;

    private String mAlbumId;
    private String mPlayListId;
    private RealmHelper mRealmHelper;
    private AlbumModel mAlbumModel;
    private PlayListModel mPlayListModel;

//    private String mMusicId;
//    private MusicModel mMusicModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        initData();
        initView();
    }

    private void initData () {
        isAlbum = getIntent().getBooleanExtra(IS_ALBUM, false);
        isPlayList = getIntent().getBooleanExtra(IS_PLAYLIST, false);

        mAlbumId = getIntent().getStringExtra(ALBUM_ID);
        mPlayListId = getIntent().getStringExtra(PLAYLIST_ID);
        mRealmHelper = new RealmHelper();
        mAlbumModel = mRealmHelper.getAlbum(mAlbumId);
        mPlayListModel = mRealmHelper.getPlayList(mPlayListId);

    }

    private void initView () {
        initNavBar(true, "歌单列表", false);

        bg_icon = fd(R.id.bg_icon);
        iv_icon = fd(R.id.iv_icon);
        al_title = fd(R.id.al_title);
        tv_info = fd(R.id.tv_info);

        if(isAlbum==true && isPlayList==false){
            Glide.with(this)
                    .load(mAlbumModel.getPoster())
                    .into(iv_icon);
            Glide.with(this)
                    .load(mAlbumModel.getPoster())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                    .into(bg_icon);
            al_title.setText(mAlbumModel.getTitle());
            tv_info.setText(mAlbumModel.getIntro());
            mAdapter = new MusicListAdapter(this, null, mAlbumModel.getList());
        }
        if(isAlbum==false && isPlayList==true){
            Glide.with(this)
                    .load(mPlayListModel.getPoster())
                    .into(iv_icon);
            Glide.with(this)
                    .load(mPlayListModel.getPoster())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                    .into(bg_icon);
            al_title.setText(mPlayListModel.getTitle());
            tv_info.setText(mPlayListModel.getIntro());
            mAdapter = new MusicListAdapter(this, null, mPlayListModel.getList());
        }


        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmHelper.close();
    }
}
