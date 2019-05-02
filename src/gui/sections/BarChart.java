/*
 * Copyright (C) 2019 AyShe2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gui.sections;

import java.awt.Color;
import java.awt.Paint;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author User
 * @see https://stackoverflow.com/a/29709153/230513
 */
public class BarChart {

    private static CategoryDataset createDataset(ResultSet rs) throws SQLException {
        String row = "Row";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while (rs.next()) {
            dataset.addValue(rs.getInt(2), row, rs.getString(1));
        }
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        CategoryAxis categoryAxis = new CategoryAxis("");
        ValueAxis valueAxis = new NumberAxis("");
        valueAxis.setVisible(false);
        BarRenderer renderer = new BarRenderer() {

            @Override
            public Paint getItemPaint(int row, int column) {
                switch (column) {
                    case 0: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(255, 11, 85, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 1: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(10, 255, 182, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 2: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(0, 156, 252, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 3: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(253, 95, 0, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 4: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(227, 196, 168, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 5: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(249, 253, 80, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 6: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(164, 252, 81, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 7: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(169, 81, 252, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 8: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(21, 205, 168, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 9: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(238, 193, 234, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 10: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(255, 251, 190, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    case 11: {
                        float[] hsb = new float[3];
                        hsb = Color.RGBtoHSB(222, 224, 217, hsb);
                        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
                    }
                    default:
                        return Color.red;
                }
            }
        };
        renderer.setDrawBarOutline(false);
        renderer.setBarPainter(new StandardBarPainter());
        CategoryPlot plot = new CategoryPlot(dataset, categoryAxis,
                valueAxis, renderer);
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT,
                plot, false);
        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public static JFrame display(ResultSet rs) throws SQLException {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset(rs)));
        f.add(chartPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(1000, 700);
        return f;
    }
}
