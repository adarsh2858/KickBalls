package com.adarsh.kickballs;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static List<User> users = new ArrayList<User>();
    private TableLayout tableLayout;
    private LinearLayout rootLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences mPrefs = this.getActivity().getPreferences(MODE_PRIVATE);
        User myObject = new User("p03", "Nilam", 52, "Description for Score 3", R.drawable.green_circle);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(myObject);
        //set variables of 'myObject', etc.
        prefsEditor.putString("MyObject", json);
        prefsEditor.commit();

        String json2 = mPrefs.getString("MyObject", "");
        User obj = gson.fromJson(json2, User.class);
        System.out.println(json2);
        System.out.println("json");
        initView();
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    private void initView() {
        tableLayout = getView().findViewById(R.id.tableLayoutProduct);
        rootLayout = getView().findViewById(R.id.rootLayout);
    }

    private void loadData() {
//        if (users.size() == 0)
//            users.add(new User("p01", "Adarsh", 20, "Description for Score 1", R.drawable.green_circle));

        if (users.size() != 0)
            createColumns();
        else {
            ConstraintLayout root = new ConstraintLayout(getContext());
            root.setLayoutParams(new ConstraintLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            ConstraintSet constraintSet = new ConstraintSet();

            TextView noDataAvailable = new TextView(getContext());
            noDataAvailable.setText("No Data Available");
            noDataAvailable.setId(R.id.noData);
            noDataAvailable.setTextColor(ContextCompat.getColor(getContext(),R.color.textColor));

            root.addView(noDataAvailable);

            constraintSet.constrainHeight(noDataAvailable.getId(), ConstraintSet.WRAP_CONTENT);
            constraintSet.constrainWidth(noDataAvailable.getId(), ConstraintSet.WRAP_CONTENT);

            constraintSet.connect(noDataAvailable.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
            constraintSet.connect(noDataAvailable.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
            constraintSet.connect(noDataAvailable.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
            constraintSet.connect(noDataAvailable.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

            constraintSet.applyTo(root);
            rootLayout.addView(root);
        }

        fillData(users);
    }

    private void createColumns() {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
//        TextView textViewId = new TextView(getContext());
//        textViewId.setText("Id");
//        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewId.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewId);

        // Name Column
        TextView textViewName = new TextView(getContext());
        textViewName.setText("Name");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Score Column
        TextView textViewScore = new TextView(getContext());
        textViewScore.setText("Score");
        textViewScore.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewScore.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewScore);


        // Photo Column
//        TextView textViewPhoto = new TextView(getContext());
//        textViewPhoto.setText("Photo");
//        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPhoto.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Add Divider
        tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
//        textViewId = new TextView(getContext());
//        textViewId.setText("-----------");
//        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewId.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewId);

        // Name Column
        textViewName = new TextView(getContext());
//        textViewName.setText("-----------");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Score Column
        textViewScore = new TextView(getContext());
//        textViewScore.setText("-----------");
        textViewScore.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewScore.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewScore);

        // Photo Column
//        textViewPhoto = new TextView(getContext());
//        textViewPhoto.setText("-------------------------");
//        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//        textViewPhoto.setPadding(5, 5, 5, 0);
//        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

    }

    private void fillData(List<User> users) {
        for (User user : users) {
            TableRow tableRow = new TableRow(getContext());
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow currentRow = (TableRow) view;
                    TextView textViewId = (TextView) currentRow.getChildAt(0);
                    String id = textViewId.getText().toString();
                    Toast.makeText(getContext(), id, Toast.LENGTH_LONG).show();
                }
            });

            // Id Column
//            TextView textViewId = new TextView(getContext());
//            textViewId.setText(product.getId());
//            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
//            textViewId.setPadding(5, 5, 5, 0);
//            tableRow.addView(textViewId);

            // Name Column
            TextView textViewName = new TextView(getContext());
            textViewName.setText(user.getName());
            textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewName.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewName);

            // Score Column
            TextView textViewScore = new TextView(getContext());
            textViewScore.setText(String.valueOf(user.getScore()));
            textViewScore.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewScore.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewScore);

            // Photo Column
//            ImageView imageViewPhoto = new ImageView(getContext());
//            imageViewPhoto.setImageResource(product.getPhoto());
//            tableRow.addView(imageViewPhoto);
//            System.out.println(imageViewPhoto);
//            System.out.println(product.getPhoto());

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}