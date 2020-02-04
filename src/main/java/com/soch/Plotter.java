package com.soch;

import javafx.util.Pair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.util.List;

public class Plotter extends ApplicationFrame {
    public Plotter(String title, List<Pair> data) {
        super(title);

        final XYSeries series = new XYSeries("Random data", false);
        for (Pair<Integer, Integer> pair : data) {
            series.add(pair.getKey(), pair.getValue());
        }
        final XYSeriesCollection xySeriesCollection = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart(title, "set size",
                "nanoseconds", xySeriesCollection, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);

        //TODO: Drut, uwazac na zakres
        plot.getDomainAxis().setRange(-100000, 1000000);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
        setContentPane(chartPanel);
    }
}
