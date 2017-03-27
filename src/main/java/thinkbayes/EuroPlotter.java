package thinkbayes;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class EuroPlotter extends Application {

    public static final int START_EVENT = 0;
    public static final int END_EVENT = 100;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Probability Distribution");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of locomotives");

        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Probability of Hypothesis Given Data");
        lineChart.setCreateSymbols(false);

        List<Integer> hypotheses = IntStream.rangeClosed(START_EVENT, END_EVENT).boxed().collect(Collectors.toList());
        List<Flip> observations = new LinkedList<>();
        for(int i = 0; i < 140; i++)
            observations.add(Flip.HEADS);
        for(int i = 140; i < 250; i++)
            observations.add(Flip.TAILS);

        Euro euro1 = new Euro(hypotheses);
        XYChart.Series series1 = new XYChart.Series();
        lineChart.getData().add(series1);
        series1.setName("Uniform Prior");
        series1.getData().addAll(
                IntStream.rangeClosed(START_EVENT, END_EVENT)
                        .mapToObj(i -> new XYChart.Data(i, euro1.getEvent(i)))
                        .collect(Collectors.toList())
        );

        for (Flip observation : observations) {
            euro1.updateHypotheses(observation);
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Posterior for Uniform Prior");
        lineChart.getData().add(series2);
        series2.getData().addAll(
                IntStream.rangeClosed(START_EVENT, END_EVENT)
                        .mapToObj(i -> new XYChart.Data(i, euro1.getEvent(i)))
                        .collect(Collectors.toList())
        );

        Scene scene  = new Scene(lineChart,1368, 768);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}
