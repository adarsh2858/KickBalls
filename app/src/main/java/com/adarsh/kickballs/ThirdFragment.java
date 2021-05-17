package com.adarsh.kickballs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("p01", "Name 1", 4, "Description for Product 1", R.drawable.green_circle));
        products.add(new Product("p02", "Name 2", 8, "Description for Product 2", R.drawable.green_circle));
        products.add(new Product("p03", "Name 3", 9, "Description for Product 3", R.drawable.green_circle));
        products.add(new Product("p04", "Name 4", 11, "Description for Product 4", R.drawable.green_circle));
        products.add(new Product("p05", "Name 5", 5, "Description for Product 5", R.drawable.green_circle));
        products.add(new Product("p06", "Name 6", 21, "Description for Product 6", R.drawable.green_circle));
        products.add(new Product("p07", "Name 7", 15, "Description for Product 7", R.drawable.green_circle));
        products.add(new Product("p08", "Name 8", 8, "Description for Product 8", R.drawable.green_circle));
        products.add(new Product("p09", "Name 9", 32, "Description for Product 9", R.drawable.green_circle));

        createColumns();
        fillData(products);
    }

    private void createColumns() {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        TextView textViewId = new TextView(getContext());
        textViewId.setText("Id");
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewId);

        // Name Column
        TextView textViewName = new TextView(getContext());
        textViewName.setText("Name");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Price Column
        TextView textViewPrice = new TextView(getContext());
        textViewPrice.setText("Price");
        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPrice.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPrice);

        // Photo Column
        TextView textViewPhoto = new TextView(getContext());
        textViewPhoto.setText("Photo");
        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPhoto.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Add Divider
        tableRow = new TableRow(getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        textViewId = new TextView(getContext());
        textViewId.setText("-----------");
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewId);

        // Name Column
        textViewName = new TextView(getContext());
        textViewName.setText("-----------");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Price Column
        textViewPrice = new TextView(getContext());
        textViewPrice.setText("-----------");
        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPrice.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPrice);

        // Photo Column
        textViewPhoto = new TextView(getContext());
        textViewPhoto.setText("-------------------------");
        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPhoto.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

    }

    private void fillData(List<Product> products) {
        for (Product product : products) {
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
            TextView textViewId = new TextView(getContext());
            textViewId.setText(product.getId());
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewId.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewId);

            // Name Column
            TextView textViewName = new TextView(getContext());
            textViewName.setText(product.getName());
            textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewName.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewName);

            // Price Column
            TextView textViewPrice = new TextView(getContext());
            textViewPrice.setText(getText(R.string.usd) + String.valueOf(product.getPrice()));
            textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewPrice.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewPrice);

            // Photo Column
            ImageView imageViewPhoto = new ImageView(getContext());
            imageViewPhoto.setImageResource(product.getPhoto());
            tableRow.addView(imageViewPhoto);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}