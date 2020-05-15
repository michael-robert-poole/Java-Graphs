package Main.Java.MVC;

import Main.Java.MVC.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage window) throws InterruptedException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

        model.controller = controller;
        controller.model = model;
        controller.view = view;
        view.controller = controller;
        view.start(window);

        model.getGraph();


        //model.depthFirstTraversal("Bob");


       // System.out.println(model.depthFirstTraversal("Bob"));
    }
}
