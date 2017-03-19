package thinkbayes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LocomotivePlotter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Probability of Hypothesis Given Data");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of locomotives");

        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Probability of Occurrence");
        lineChart.setCreateSymbols(false);

        // Assume that a company can have anywhere from 1 to 1000 locomotvies
        List<Integer> hypothesis = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
        Locomotive locomotive = new Locomotive(hypothesis);
        // We saw a locomotive with the identifier 60
        locomotive.updateHypotheses(60);

        XYChart.Series series = new XYChart.Series();
        series.setName("Saw a locomotive with " + String.valueOf(60));
        lineChart.getData().add(series);
        series.getData().addAll(
                IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> new XYChart.Data(i, locomotive.getEvent(i)))
                .collect(Collectors.toList())
        );
        Scene scene  = new Scene(lineChart,1368, 768);
        stage.setScene(scene);
        stage.show();
    }
}
