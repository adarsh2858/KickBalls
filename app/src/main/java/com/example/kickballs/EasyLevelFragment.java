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

public class EasyLevelFragment extends Fragment {

    Button firstLevel, secondLevel, thirdLevel, fourthLevel, fifthLevel, sixthLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.activity_main, container, false);

        firstLevel = rootView.findViewById(R.id.btn_1);
        secondLevel = rootView.findViewById(R.id.btn_2);
        thirdLevel = rootView.findViewById(R.id.btn_3);
        fourthLevel = rootView.findViewById(R.id.btn_4);
        fifthLevel = rootView.findViewById(R.id.btn_5);
        sixthLevel = rootView.findViewById(R.id.btn_6);

        firstLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 1", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), FirstLevel.class));
            }
        });

        secondLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 2", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), SecondLevel.class));
            }
        });

        thirdLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 3", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), ThirdLevel.class));
            }
        });

        fourthLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 4", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), FourthLevel.class));
            }
        });

        fifthLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 5", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), FifthLevel.class));
            }
        });

        sixthLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 6", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), SixthLevel.class));
            }
        });

        return rootView;
    }
}