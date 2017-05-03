package com.gm.a80066158.recylerviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 80066158 on 2017-05-02.
 */

public class GeneralRecyclerViewFragmentTest extends GeneralRecyclerViewFragment {
    private static final String TAG = "GeneralRecyclerViewFragmentTest";

    @Override
    protected void onItemClick(int position) {
        Log.i(TAG, "<onItemClick> position = " + position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setDataList(getDataList());
        return view;
    }

    private List<GeneralRecyclerViewItemData> getDataList() {
        List<GeneralRecyclerViewItemData> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            GeneralRecyclerViewItemData itemData = new GeneralRecyclerViewItemData();
            itemData.setDefaultIconId(R.mipmap.ic_launcher);
            itemData.setTitle("title" + i);
            itemData.setSubTitle("subtitle" + i);

            dataList.add(itemData);
        }

        return dataList;
    }
}
