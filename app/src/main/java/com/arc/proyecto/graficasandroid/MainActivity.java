package com.arc.proyecto.graficasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ScatterChart grafica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grafica = findViewById(R.id.grafica);

        setTitle("ScatterChartActivity");

        grafica.getDescription().setEnabled(false);
        grafica.setDrawGridBackground(false);

        grafica.setDragEnabled(true);
        grafica.setPinchZoom(true);

        Legend legend = grafica.getLegend();

        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setDrawInside(false);

        List<Entry> entries1 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            int valor = (int)Math.floor(Math.random() *(100-1)+1);
            entries1.add(new Entry(i,valor));

        }
        ScatterDataSet dataSet1 = new ScatterDataSet(entries1,entries1.size()+" Vecinos");
        dataSet1.setScatterShape(ScatterChart.ScatterShape.TRIANGLE);
        dataSet1.setHighlightEnabled(true);
        dataSet1.setDrawHighlightIndicators(true);
        dataSet1.setDrawValues(true);
        dataSet1.setScatterShapeSize(20f);
        dataSet1.setColor(ColorTemplate.MATERIAL_COLORS[3]);

        YAxis yAxisL = grafica.getAxisLeft();
        yAxisL.setAxisMinimum(0);
        yAxisL.setAxisMaximum(100);
        yAxisL.setSpaceBottom(0f);

        YAxis yAxisR = grafica.getAxisRight();
        yAxisR.setAxisMinimum(0);
        yAxisR.setAxisMaximum(100);
        yAxisR.setSpaceBottom(0f);

        grafica.setKeepPositionOnRotation(true);
        grafica.setDrawBorders(true);
        grafica.animateX(2000, Easing.EaseInOutQuart);

        XAxis xAxis = grafica.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMaximum(100);
        xAxis.setAxisMinimum(0);
        xAxis.setGranularity(1f);


        ScatterData scatterData = new ScatterData(dataSet1);
        grafica.setData(scatterData);
        grafica.invalidate();


    }
}
