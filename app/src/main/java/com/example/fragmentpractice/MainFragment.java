package com.example.fragmentpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment
{
    private EditText mText;
    private Button mPassing, mCommunication;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        initView(view);
        setValues();
        return view;
    }

    private void initView(View view) {
        mText = view.findViewById(R.id.et_text);
        mPassing = view.findViewById(R.id.bt_passing);
        mCommunication = view.findViewById(R.id.bt_communication);
    }

    private void setValues() {
        mPassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = mText.getText().toString();
                Intent intent = new Intent(getActivity(),DisplayActivity.class);
                intent.putExtra("text",data);
                startActivity(intent);
            }
        });

        mCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CommunicationActivity.class);
                startActivity(intent);
            }
        });
    }
}
