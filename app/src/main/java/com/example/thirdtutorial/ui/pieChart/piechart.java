package com.example.thirdtutorial.ui.pieChart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thirdtutorial.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class piechart extends Fragment {

    private TextView tvR, tvPython, tvCPP, tvJava;
    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_piechart, container, false);

        tvR = rootView.findViewById(R.id.tvR);
        tvPython = rootView.findViewById(R.id.tvPython);
        tvCPP = rootView.findViewById(R.id.tvCPP);
        tvJava = rootView.findViewById(R.id.tvJava);
        pieChart = rootView.findViewById(R.id.piechart);

        setData();

        return rootView;
    }

    private void setData() {
        tvR.setText(Integer.toString(40));
        tvPython.setText(Integer.toString(30));
        tvCPP.setText(Integer.toString(5));
        tvJava.setText(Integer.toString(25));

        pieChart.addPieSlice(
                new PieModel("Chinese cuisine", Integer.parseInt(tvR.getText().toString()), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel("Japanese cuisine", Integer.parseInt(tvPython.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel("Malay cuisine", Integer.parseInt(tvCPP.getText().toString()), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel("Filipino cuisine", Integer.parseInt(tvJava.getText().toString()), Color.parseColor("#29B6F6")));

        pieChart.startAnimation();
    }
}