package com.adarsh.kickballs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

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
    private TableLayout tableLayout;

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
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    }

    private void loadData() {
        List<User> users = new ArrayList<User>();
        users.add(new User("p01", "Adarsh", 20, "Description for Score 1", R.drawable.green_circle));
//        products.add(new Product("p02", "Name 2", 8, "Description for Product 2", R.drawable.green_circle));
//        products.add(new Product("p03", "Name 3", 9, "Description for Product 3", R.drawable.green_circle));
//        products.add(new Product("p04", "Name 4", 11, "Description for Product 4", R.drawable.green_circle));
//        products.add(new Product("p05", "Name 5", 5, "Description for Product 5", R.drawable.green_circle));
//        products.add(new Product("p06", "Name 6", 21, "Description for Product 6", R.drawable.green_circle));
//        products.add(new Product("p07", "Name 7", 15, "Description for Product 7", R.drawable.green_circle));
//        products.add(new Product("p08", "Name 8", 8, "Description for Product 8", R.drawable.green_circle));
//        products.add(new Product("p09", "Name 9", 32, "Description for Product 9", R.drawable.green_circle));

        createColumns();
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