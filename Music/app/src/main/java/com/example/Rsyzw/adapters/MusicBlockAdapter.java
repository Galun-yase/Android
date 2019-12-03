package com.example.Rsyzw.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Rsyzw.R;
import com.example.Rsyzw.activitys.RankActivity;


public class MusicBlockAdapter extends RecyclerView.Adapter<MusicBlockAdapter.ViewHolder> {

    private Context mContext;
    private int mItemCount;
    private String[] blockTitle;
    private int[] blockImage;
    private int n = 0;
    private final int pos = 3;
//    private Map<String,Object> block = new HashMap<>(2);

    public MusicBlockAdapter(Context context, String[] bt, int[] bi ) {
        mContext = context;
        mItemCount = bt.length;
        blockTitle = bt;
        blockImage = bi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.block_list_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Glide.with(mContext)
                .load(blockImage[i]) //ImagesUtil.getImagesUrl(10)
                .into(viewHolder.ivIcon);

//        viewHolder.mTvPlayNum.setText(albumModel.getPlayNum());
//        String nn = String.valueOf(n++);
//        i++;
        viewHolder.mTvName.setText(blockTitle[i]);

        n++;
        if(pos == n) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "你点了第" + pos + "个版块", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, RankActivity.class);
                mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mItemCount;
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
