package com.application.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.recyclerview.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements RestaurantFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
