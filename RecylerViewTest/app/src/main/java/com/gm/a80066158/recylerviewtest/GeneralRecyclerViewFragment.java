package com.gm.a80066158.recylerviewtest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by 80066158 on 2017-05-02.
 */

public abstract class GeneralRecyclerViewFragment extends Fragment {
    private static final String TAG = "GeneralRecyclerViewFragment";

    private View myView = null;
    private RecyclerView recyclerView = null;
    private GeneralRecyclerViewAdapter recyclerViewAdapter = null;
    private List<GeneralRecyclerViewItemData> dataList = null;

    protected abstract void onItemClick(int position);

    public void setDataList(List<GeneralRecyclerViewItemData> dataList) {
        this.dataList = dataList;
        if (null != recyclerViewAdapter) {
            recyclerViewAdapter.setDataList(dataList);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "<onCreateView> start");

        if (null == myView) {
            myView = inflater.inflate(R.layout.general_recycler_view_fragment_layout, container, false);
            initContent();
        }

        return myView;
    }

    private void initContent() {
        Log.i(TAG, "<initContent> start");

        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewAdapter = new GeneralRecyclerViewAdapter(getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setDataList(dataList);
        recyclerViewAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick((Integer) view.getTag());
            }
        });
    }
}
