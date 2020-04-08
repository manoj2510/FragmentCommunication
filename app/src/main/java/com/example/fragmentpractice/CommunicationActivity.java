package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class CommunicationActivity extends AppCompatActivity implements DataListener{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        addFragmentSendData();

    }

    @Override
    public void receive(String data) {
        addFragmentReceiveData(data);

    }

    private void addFragmentSendData()
    {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        SendFragment sendFragment = new SendFragment();
        fragmentTransaction.add(R.id.container_send_data,sendFragment,"SEND_FRAGMENT");
        fragmentTransaction.commit();
    }

    private void addFragmentReceiveData(String data)
    {
        Bundle bundle = new Bundle();
        bundle.putString("sendKey",data);
        ReceiveFragment receiveFragment = new ReceiveFragment();
        receiveFragment.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container_receive_data,receiveFragment,"RECEIVE_FRAGMENT");
        fragmentTransaction.commit();
    }
}
