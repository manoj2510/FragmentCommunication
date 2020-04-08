package com.example.fragmentpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment
{
    private TextView mDisplayText;
    private String data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display,container,false);
        initView(view);
        setValues();
        return view;
    }

    private void initView(View view) {
        mDisplayText = view.findViewById(R.id.tv_display_text);
        data = getArguments().getString("data");
    }

    private void setValues() {
        mDisplayText.setText(data);
    }
}
