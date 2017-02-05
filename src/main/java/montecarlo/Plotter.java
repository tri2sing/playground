package montecarlo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Plotter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Bet#");

        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Betting Outcome");
        lineChart.setCreateSymbols(false);

        // generating the data
        int numBettors = 100;
        for (int i = 0; i < numBettors; i++) {
            XYChart.Series series = new XYChart.Series();
            series.setName(String.valueOf(i));
            lineChart.getData().add(series);

            SimpleBettor simpleBettor = new SimpleBettor(10000, 100, 10000);
            simpleBettor.placeWagers();
            float [] progression = simpleBettor.placeWagers();
            series.getData().addAll(
                    IntStream.range(0, progression.length)
                    .mapToObj(k -> new XYChart.Data<>(k, progression[k]))
                    .collect(Collectors.toList())
            );
        }
        Scene scene  = new Scene(lineChart,1368, 768);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }}
