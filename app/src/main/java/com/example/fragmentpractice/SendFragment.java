package com.example.fragmentpractice;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SendFragment extends Fragment
{
    private DataListener dataListener;
    private EditText mEditText;
    private Button mSendButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_send_data,container,false);
        initView(view);
        setValues();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dataListener = (DataListener) context;
    }

    private void initView(View view) {
        mEditText=view.findViewById(R.id.et_data_text);
        mSendButton=view.findViewById(R.id.bt_send);
    }

    private void setValues()
    {
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = mEditText.getText().toString();
                dataListener.receive(data);
            }
        });
    }

}
