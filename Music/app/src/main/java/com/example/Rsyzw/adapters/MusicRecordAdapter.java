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
import com.example.Rsyzw.models.PlayListModel;

import java.util.List;


public class MusicRecordAdapter extends RecyclerView.Adapter<MusicRecordAdapter.ViewHolder> {

    private Context mContext;
//    private int mItemCount;
//    private ArrayList<String> images;

    private List<PlayListModel> mDataSource;

    public MusicRecordAdapter(Context context, List<PlayListModel> dataSource) {
        mContext = context;
        this.mDataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final PlayListModel playListModel = mDataSource.get(i);

        Glide.with(mContext)
                .load(playListModel.getPoster())
                .into(viewHolder.ivIcon);

        viewHolder.mTvPlayNum.setText(playListModel.getPlayNum());
        viewHolder.mTvName.setText(playListModel.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlbumListActivity.class);
                intent.putExtra(AlbumListActivity.PLAYLIST_ID, playListModel.getPlayListId());

                intent.putExtra(AlbumListActivity.IS_ALBUM, false);
                intent.putExtra(AlbumListActivity.IS_PLAYLIST, true);

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
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

        }
    }

}
