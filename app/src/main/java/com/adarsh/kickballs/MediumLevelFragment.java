package com.adarsh.kickballs;

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

import com.adarsh.kickballs.mediumlevels.MediumLevelOne;
import com.adarsh.kickballs.mediumlevels.MediumLevelThree;
import com.adarsh.kickballs.mediumlevels.MediumLevelTwo;

public class MediumLevelFragment extends Fragment {

    Button firstMediumLevel, secondMediumLevel, thirdMediumLevel, fourth, fifth, sixth, seventh,
            eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_medium_level, container, false);

        firstMediumLevel = rootView.findViewById(R.id.btn_pool_1);
        secondMediumLevel = rootView.findViewById(R.id.btn_pool_2);
        thirdMediumLevel = rootView.findViewById(R.id.btn_pool_3);
        fourth = rootView.findViewById(R.id.btn_pool_4);
        fifth = rootView.findViewById(R.id.btn_pool_5);
        sixth = rootView.findViewById(R.id.btn_pool_6);
        seventh = rootView.findViewById(R.id.btn_pool_7);
        eighth = rootView.findViewById(R.id.btn_pool_8);
        ninth = rootView.findViewById(R.id.btn_pool_9);
        tenth = rootView.findViewById(R.id.btn_pool_10);
        eleventh = rootView.findViewById(R.id.btn_pool_11);
        twelfth = rootView.findViewById(R.id.btn_pool_12);
        thirteenth = rootView.findViewById(R.id.btn_pool_13);
        fourteenth = rootView.findViewById(R.id.btn_pool_14);
        fifteenth = rootView.findViewById(R.id.btn_pool_15);

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

        fourth.setAlpha(0.5f);
        fifth.setAlpha(0.5f);
        sixth.setAlpha(0.5f);
        seventh.setAlpha(0.5f);
        eighth.setAlpha(0.5f);
        ninth.setAlpha(0.5f);
        tenth.setAlpha(0.5f);
        eleventh.setAlpha(0.5f);
        twelfth.setAlpha(0.5f);
        thirteenth.setAlpha(0.5f);
        fourteenth.setAlpha(0.5f);
        fifteenth.setAlpha(0.5f);

        return rootView;
    }
}
