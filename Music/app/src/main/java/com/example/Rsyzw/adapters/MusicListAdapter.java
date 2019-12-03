package com.example.Rsyzw.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.Rsyzw.R;
import com.example.Rsyzw.activitys.PlayMusicActivity;
import com.example.Rsyzw.models.MusicModel;

import java.util.List;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;

    private int listCount;

    private List<MusicModel> mDataSource;

    private int n = 1;

//    public MusicListAdapter (Context context, RecyclerView recyclerView, int listCounts) {
//        listCount = listCounts;
//        mContext = context;
//        mRv = recyclerView;
//    }

    public MusicListAdapter (Context context, RecyclerView recyclerView, List<MusicModel> dataSource) {
        mContext = context;
        mRv = recyclerView;
        this.mDataSource = dataSource;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mRv != null) mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        else mItemView = LayoutInflater.from(mContext).inflate(R.layout.album_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        setRecyclerViewHeight();

        final MusicModel musicModel = mDataSource.get(i);

        if(mRv != null){
//            Glide.with(mContext)
//                    .load(ImagesUtil.getImagesUrl(10)) //"https://img1.mukewang.com/533e4d660001312002000200-100-100.jpg"
//                    .into(viewHolder.ivIcon);

            Glide.with(mContext)
                    .load(musicModel.getPoster())
                    .into(viewHolder.ivIcon);
        }else{

//            for(int k = 0;k<listCount;k++){
            String nn = String.valueOf(n++);
//            i++;
            viewHolder.tvNum.setText(nn);
//                n++;
//            }

        }

//        viewHolder.tvName.setText("歌名");
//        viewHolder.tvAuthor.setText("歌手");
        viewHolder.tvName.setText(musicModel.getName());
        viewHolder.tvAuthor.setText(musicModel.getAuthor());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                intent.putExtra(PlayMusicActivity.MUSIC_ID, musicModel.getMusicId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
//        return listCount;
    }

    /**
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、使用 itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight () {

        if (isCalcaulationRvHeight || mRv == null) return;
//        Log.i("MusicListAdapter", isCalcaulationRvHeight + ":" + mRv);
        isCalcaulationRvHeight = true;

//        获取ItemView的高度
        RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
//        itemView的数量
        int itemCount = getItemCount();
//        使用 itemViewHeight * itemViewNum = RecyclerView的高度
        int recyclerViewHeight = itemViewLp.height * itemCount;
//        设置RecyclerView高度
        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView ivIcon;
        TextView tvName, tvAuthor, tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAuthor = itemView.findViewById(R.id.tv_author);

            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }
}
