package com.gm.a80066158.recylerviewtest;

import android.util.Log;

/**
 * Created by 80066158 on 2017-05-02.
 */

public class GeneralRecyclerViewFragmentTest extends GeneralRecyclerViewFragment {
    private static final String TAG = "GeneralRecyclerViewFragmentTest";

    @Override
    protected void onItemClick(int position) {
        Log.i(TAG, "<onItemClick> position = " + position);
    }
}
