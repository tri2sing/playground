package name.adhikari.sameer.playground.lambdaslynda.CanonicalExamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonImpl extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Classical approach using an annonymous inner class
        // that implements the EventHandler interface.
        Button btn1 = new Button();
        btn1.setText("Classical Button");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World from Classical Button");
            }
        });

        // Lambda approach which makes the code concise.
        // Note that even the () for arguments, and {}
        // for the body can be excluded in some cases.
        Button btn2 = new Button();
        btn2.setText("Lambda Button");
        //btn2.setOnAction((event) -> {System.out.println("Hello World from Lambda Button")});
        btn2.setOnAction(event -> System.out.println("Hello World from Lambda Button"));

        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(50);
        flowPane.setHgap(50);
        flowPane.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(flowPane, 300, 200);
        primaryStage.setTitle("Lamda Demonstration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
