package com.example.Rsyzw.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.Rsyzw.R;
import com.example.Rsyzw.utils.RankUtils;

/**
 * Created by caobotao on 16/1/4.
 */
public class DayRankFragment extends Fragment {

    private Context mContext;
    private TextView musicListName;

    public DayRankFragment(Context context){
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);

        RankUtils.rankSetView(mContext, view, R.id.day_rank_list);

//        LinearLayout item = view.findViewById(R.id.tab_day);//父布局
//        LayoutInflater inflater2 = LayoutInflater.from(mContext);
//        View view2 = inflater2.inflate(R.layout.music_list,item,true);
//        musicListName = view2.findViewById(R.id.ml_name);
//        container.addView(view2);
//        View view2 = inflater.inflate(R.layout.music_list, container, true);
//        musicListName = view2.findViewById(R.id.ml_name);
//        System.out.println("view2="+view2);
//        System.out.println("ml_name的id="+R.id.ml_name);
//        musicListName = view2.findViewById(R.id.ml_name);

//        container.addView(view.findViewById(R.id.ml_list));
//        View view2 = inflater.inflate(R.layout.music_list, container, false);
//        musicListName = container.getChildAt(container.getChildCount()).findViewById(R.id.ml_name);

//        musicListName.setText("日排行榜");

        return view;
    }
}
