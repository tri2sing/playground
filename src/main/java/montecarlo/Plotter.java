package montecarlo;

import java.lang.reflect.Constructor;
import java.util.Map;
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

            //Bettor bettor = new SimpleBettor(10000, 100, 10000);
            Bettor bettor = getBettor();
            bettor.placeWagers();
            Float [] progression = bettor.placeWagers();
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

    private Bettor getBettor() {
        Bettor bettor = null;
        Map<String, String> opts = getParameters().getNamed();
        String className = opts.get("classname");
        Integer wagerAttempts = Integer.parseInt(opts.get("wagerattempts"));
        Float wagerAmount = Float.parseFloat(opts.get("wageramount"));
        Float startingCapital = Float.parseFloat(opts.get("startingcapital"));

        try {
            Class [] argTypes = new Class[] {Integer.class, Float.class, Float.class};
            Object [] argValues = new Object[] {wagerAttempts, wagerAmount, startingCapital};
            Class<?> classRef = Class.forName(className);
            Constructor<?> constructor = classRef.getDeclaredConstructor(argTypes);
            bettor = (Bettor) constructor.newInstance(argValues);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bettor;
    }

    // Possible maven run configuration for the plotter are:
    // mvn exec:java -Dexec.mainClass="montecarlo.Plotter" -Dexec.args="--classname=montecarlo.SimpleBettor --wagerattempts=5000 --wageramount=100 --startingcapital=1000"
    // mvn exec:java -Dexec.mainClass="montecarlo.Plotter" -Dexec.args="--classname=montecarlo.DoublerBettor --wagerattempts=5000 --wageramount=100 --startingcapital=1000"
    public static void main(String[] args) {
        launch(args);
    }
}
