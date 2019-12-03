package com.example.Rsyzw.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;

import com.example.Rsyzw.R;

public class BaseActivity extends Activity {

    private ImageView mIvBack, mIvMe;
    private TextView mIvTitle;

    private Context mContext;

    protected <T extends View> T fd(@IdRes int id){
        return findViewById(id);
    }

    protected void initNavBar(boolean isShowBack, String title, boolean isShowMe){

        mIvBack = fd(R.id.iv_back);
        mIvTitle = fd(R.id.tv_title);
        mIvMe = fd(R.id.iv_me);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvTitle.setText(title);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });

    }

    public void initNavBar2(boolean isShowBack, String title, boolean isShowMe,
                            ImageView mBack, TextView mTitle, ImageView mMe, Context context){

        mContext = context;

        mBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mTitle.setText(title);
        mMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onBackPressed();
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

        mMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MeActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

}
