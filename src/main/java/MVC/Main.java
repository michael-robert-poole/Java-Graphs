package main.java.MVC;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage window) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

        model.setController(controller);
        controller.setModel(model);
        controller.setView(view);
        view.controller = controller;
        view.start(window);

        model.getGraph();
    }
}
