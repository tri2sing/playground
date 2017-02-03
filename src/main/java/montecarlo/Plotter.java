package montecarlo;

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
        // TODO: figure out how make thin lines
        //lineChart.setStyle("-fx-stroke-width: 100;");

        int numBettors = 10;
        for (int i = 0; i < numBettors; i++) {
            XYChart.Series series = new XYChart.Series();
            series.setName(String.valueOf(i));
            Bettor bettor = new Bettor(1000, 100, 1000);
            bettor.placeWagers();
            float [] progression = bettor.getWagerProgression();
            for(int k = 0; k < progression.length; k++) {
                series.getData().add(new XYChart.Data<>(k, progression[k]));
            }
            lineChart.getData().add(series);
/*
            IntStream.range(0, progression.length)
                    .mapToObj(k -> series.getData().add(new XYChart.Data<>(k, progression[k])));
*/
        }
        Scene scene  = new Scene(lineChart,800,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }}
