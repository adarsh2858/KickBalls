package com.example.kickballs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kickballs.R;
import com.example.kickballs.mediumlevels.MediumLevelOne;

public class MediumLevelFragment extends Fragment {

    Button firstMediumLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medium_level, container, false);

        firstMediumLevel = rootView.findViewById(R.id.btn_pool_1);

        firstMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Medium Level 1", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MediumLevelOne.class));
            }
        });

        return rootView;
    }
}
