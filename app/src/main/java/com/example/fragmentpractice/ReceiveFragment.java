package com.example.fragmentpractice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReceiveFragment extends Fragment {

    private TextView mDisplayTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receive_data,container,false);
        initView(view);
        setValues();
        return view;
    }

    private void initView(View view) {
        mDisplayTextView = view.findViewById(R.id.tv_receive_data);
    }

    private void setValues()
    {
        assert getArguments() != null;
        String data = getArguments().getString("sendKey");
        Log.d("My Data",data);
        mDisplayTextView.setText(data);
    }
}
