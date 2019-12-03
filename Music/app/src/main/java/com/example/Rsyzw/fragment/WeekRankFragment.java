package com.example.Rsyzw.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.Rsyzw.R;
import com.example.Rsyzw.utils.RankUtils;

import javax.annotation.Nullable;

/**
 * Created by caobotao on 16/1/4.
 */
public class WeekRankFragment extends Fragment {

    private Context mContext;

    public WeekRankFragment(Context context){
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        RankUtils.rankSetView(mContext, view, R.id.week_rank_list);
        return view;
    }
}
