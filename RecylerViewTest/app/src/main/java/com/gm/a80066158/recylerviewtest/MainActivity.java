package com.gm.a80066158.recylerviewtest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        GeneralRecyclerViewFragmentTest fragment = new GeneralRecyclerViewFragmentTest();
        showFragment(fragment);
    }

    public void showFragment(Fragment fragment) {
        if (null == fragment) {
            Log.w(TAG, "<showFragment> fragment is null");
            return;
        }
        Log.i(TAG, "<showFragment> " + fragment.getClass().getName());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
