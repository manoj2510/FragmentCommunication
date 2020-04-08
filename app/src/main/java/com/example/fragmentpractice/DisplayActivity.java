package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getIntentData();
        addFragmentDisplay();

    }

    private void addFragmentDisplay() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        DisplayFragment displayFragment = new DisplayFragment();

        Bundle bundle = new Bundle();
        bundle.putString("data",data);
        displayFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.container2,displayFragment,"display");
        fragmentTransaction.commit();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        data = intent.getStringExtra("text");
    }
}
