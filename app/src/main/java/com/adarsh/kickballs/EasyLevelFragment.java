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

import com.adarsh.kickballs.easylevels.EighthLevel;
import com.adarsh.kickballs.easylevels.FifthLevel;
import com.adarsh.kickballs.easylevels.FirstLevel;
import com.adarsh.kickballs.easylevels.FourthLevel;
import com.adarsh.kickballs.easylevels.NinthLevel;
import com.adarsh.kickballs.easylevels.SecondLevel;
import com.adarsh.kickballs.easylevels.SeventhLevel;
import com.adarsh.kickballs.easylevels.SixthLevel;
import com.adarsh.kickballs.easylevels.ThirdLevel;

public class EasyLevelFragment extends Fragment {

    Button firstLevel, secondLevel, thirdLevel, fourthLevel, fifthLevel, sixthLevel, seventhLevel, eighthLevel, ninthLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_easy_level, container, false);

        firstLevel = rootView.findViewById(R.id.btn_1);
        secondLevel = rootView.findViewById(R.id.btn_2);
        thirdLevel = rootView.findViewById(R.id.btn_3);
        fourthLevel = rootView.findViewById(R.id.btn_4);
        fifthLevel = rootView.findViewById(R.id.btn_5);
        sixthLevel = rootView.findViewById(R.id.btn_6);
        seventhLevel = rootView.findViewById(R.id.btn_7);
        eighthLevel = rootView.findViewById(R.id.btn_8);
        ninthLevel = rootView.findViewById(R.id.btn_9);

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

        seventhLevel.setAlpha(0.5f);
        eighthLevel.setAlpha(0.5f);
        ninthLevel.setAlpha(0.5f);

        seventhLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 7", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), SeventhLevel.class));
            }
        });

        eighthLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 8", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), EighthLevel.class));
            }
        });

        ninthLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Level 9", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), NinthLevel.class));
            }
        });

        return rootView;
    }
}
