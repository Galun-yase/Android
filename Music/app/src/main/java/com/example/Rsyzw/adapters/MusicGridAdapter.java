package com.example.Rsyzw.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.Rsyzw.R;
import com.example.Rsyzw.activitys.AlbumListActivity;
import com.example.Rsyzw.models.AlbumModel;

import java.util.List;


public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder> {

    private Context mContext;
//    private int mItemCount;
//    private ArrayList<String> images;

    private List<AlbumModel> mDataSource;
//    private List<PlayListModel> nDataSource;

    public MusicGridAdapter (Context context, List<AlbumModel> dataSource) {
        mContext = context;
        this.mDataSource = dataSource;
//        if(dataSource == null) mItemCount = 5;
    }

//    public MusicGridAdapter (Context context, List<PlayListModel> dataSource) {
//        mContext = context;
//        this.nDataSource = dataSource;
//    }

//    public MusicGridAdapter (Context context, int itemCount) {
//        mContext = context;
//        mItemCount = itemCount;

//        images = new ArrayList<>();
//        images.add("https://images.nowcoder.com/images/20170909/4107856_1504933721660_43CAE73DE2EF35F43C1CBA030B1CF5E0?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20191105/999991341_1572923480661_47C81A001EB84E8A9F2015F21CC31AED?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190729/999991364_1564385956032_2BA333085C9987DA6E4EE0C8D96B02B2?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190926/999991356_1569483579393_294C47304E8AB5C2F85E87BC90681526?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190314/92286570_1552534617601_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190312/195593609_1552354102825_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190906/999991354_1567736520318_5792FBE40575717F4AD1F580CB6206BF?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190309/38457461_1552127330605_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20191015/226473669_1571152869877_F0666DCEA1E731869E6782CB61E0C63E?x-oss-process=image/resize,m_mfit,h_100,w_100");
//        images.add("https://images.nowcoder.com/images/20190226/94458911_1551194513275_605475850F555A9A1D76953CFB3E39A6?x-oss-process=image/resize,m_mfit,h_100,w_100");
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if(mDataSource.size() == 5) return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.block_list_music, viewGroup, false));
//        else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

//        Glide.with(mContext)
//                .load(ImagesUtil.getImagesUrl(10)) //"https://img.mukewang.com/5b037fb30001534202000199-100-100.jpg"
//                .into(viewHolder.ivIcon);
//
//        if(mItemCount != 5){
//            viewHolder.mTvPlayNum.setText("100.00万");
//            viewHolder.mTvName.setText("歌单名称");
//        }else{
//            viewHolder.mTvName.setText("电台");
//        }

        final AlbumModel albumModel = mDataSource.get(i);

        Glide.with(mContext)
                .load(albumModel.getPoster())
                .into(viewHolder.ivIcon);

        viewHolder.mTvPlayNum.setText(albumModel.getPlayNum());
        viewHolder.mTvName.setText(albumModel.getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlbumListActivity.class);
                intent.putExtra(AlbumListActivity.ALBUM_ID, albumModel.getAlbumId());

                intent.putExtra(AlbumListActivity.IS_ALBUM, true);
                intent.putExtra(AlbumListActivity.IS_PLAYLIST, false);

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
//        if(mDataSource == null) return mItemCount;
//        else
            return mDataSource.size();
//       return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIcon;
        View itemView;
        TextView mTvPlayNum, mTvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
            mTvPlayNum = itemView.findViewById(R.id.tv_play_num);
            mTvName = itemView.findViewById(R.id.tv_name);

//            Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.id.iv_icon);
////            ImageView imageView = findViewById(R.id.rv_grid);
//            ivIcon.setImageBitmap(BitMapUtils.roundBitmapByShader(bitmap,
//                    (int)mContext.getResources().getDimension(R.dimen.roundBitMapBorder),
//                    (int)mContext.getResources().getDimension(R.dimen.roundBitMapBorder),
//                    (int)mContext.getResources().getDimension(R.dimen.roundBitMapBorder)));

        }
    }

//    private Resources getResources() {
//        Resources mResources = null;
//        mResources = getResources();
//        return mResources;
//    }


}
