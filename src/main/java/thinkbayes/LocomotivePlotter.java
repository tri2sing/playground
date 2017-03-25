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
        lineChart.setTitle("Probability of number of trains given we saw 60");
        lineChart.setCreateSymbols(false);

        // Assume that a company can have anywhere from 1 to 1000 locomotvies
        List<Integer> hypotheses = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());

        Locomotive loco1 = new Locomotive(hypotheses, Prior.UNIFORM);
        // We saw a locomotive with the identifier 60
        loco1.updateHypotheses(60F);

        XYChart.Series series1 = new XYChart.Series();
        lineChart.getData().add(series1);
        series1.setName("Uniform Prior");
        series1.getData().addAll(
                IntStream.rangeClosed(1, 1000)
                        .mapToObj(i -> new XYChart.Data(i, loco1.getEvent(i)))
                        .collect(Collectors.toList())
        );

        Locomotive loco2 = new Locomotive(hypotheses, Prior.POWER_LAW);
        loco2.updateHypotheses(60F);

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Power Law Prior");
        lineChart.getData().add(series2);
        series2.getData().addAll(
                IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> new XYChart.Data(i, loco2.getEvent(i)))
                .collect(Collectors.toList())
        );

        Scene scene  = new Scene(lineChart,1368, 768);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}
