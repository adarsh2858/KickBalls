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
import com.example.kickballs.mediumlevels.MediumLevelThree;
import com.example.kickballs.mediumlevels.MediumLevelTwo;

public class MediumLevelFragment extends Fragment {

    Button firstMediumLevel, secondMediumLevel, thirdMediumLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medium_level, container, false);

        firstMediumLevel = rootView.findViewById(R.id.btn_pool_1);
        secondMediumLevel = rootView.findViewById(R.id.btn_pool_2);
        thirdMediumLevel = rootView.findViewById(R.id.btn_pool_3);

        firstMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Medium Level 1", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MediumLevelOne.class));
            }
        });

        secondMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Medium Level 2", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MediumLevelTwo.class));
            }
        });

        thirdMediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Medium Level 3", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MediumLevelThree.class));
            }
        });

        return rootView;
    }
}
