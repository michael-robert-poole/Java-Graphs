package main.java.MVC;


import main.java.GUI.Corodinates;
import main.java.GUI.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class View {
    int index = 0;
    GraphicsContext gc;
    Canvas canvas;
    Group root;
    Pane pane;
    Map<String, Node> nodes;
    List<Corodinates> coords;
    Controller controller;
    Button btn;
    Button btn2;


    public View() {
        this.nodes = new Hashtable<>();
        this.coords = new ArrayList<>();
        coords.add(new Corodinates(150, 60));
        coords.add(new Corodinates(50, 150));
        coords.add(new Corodinates(150, 150));
        coords.add(new Corodinates(250, 150));
        coords.add(new Corodinates(150, 250));
        coords.add(new Corodinates(150, 350));
        coords.add(new Corodinates(250, 250));
        coords.add(new Corodinates(250, 350));

    }


    public void start(Stage primaryStage){
        primaryStage.setTitle("Graphs and Searching Animation");
        root = new Group();
        canvas = new Canvas(550, 550);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        //drawShapes(gc);
         btn = new Button("BFS");
         btn2 = new Button("DFS");
         TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                redrawGraph();
                gc.setFill(Color.RED);
                gc.fillText("Breadth-first search:", 400, 80);
                gc.strokeLine(400, 85, 500, 85);
                controller.doBFS(tf1.getText());
               setButtons(true);

            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                redrawGraph();
                gc.setFill(Color.RED);
                gc.fillText("Depth-first search:", 400, 80);
                setButtons(true);
                controller.doDFS(tf2.getText());


            }
        });


        GridPane gp = new GridPane();
        pane = new Pane();
        //pane.setStyle("-fx-background-color: #000000");
        pane.getChildren().add(canvas);
        gp.add(pane,1,2);
        gp.add(btn, 0, 0);
        gp.add(tf1, 0,1);
        gp.add(btn2, 2,0);
        gp.add(tf2, 2,1);

        root.getChildren().add(gp);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public void redrawGraph(){
        index = 0;
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        controller.getGraph();
    }


    public void drawNodes(String label){
        Corodinates cd = coords.get(index++);
        Node node = new Node(cd.getX(), cd.getY(),15, label);
        nodes.put(label, node);
        node.draw(pane, gc);

    }

    public void updateColor(String label, int i){
        nodes.get(label).update();
        gc.setFill(Color.RED);
        gc.fillText(label, 400, 100 + i*20);
    }

    public void drawEdge(String label1, String label2, int cost){
        Node n1 = nodes.get(label1);
        Node n2 = nodes.get(label2);
        gc.strokeLine(n1.getX(), n1.getY(),n2.getX(),n2.getY());
        if(cost != 0){
            gc.fillText(Integer.toString(cost), ((n1.getX() +n2.getX())/2) + 10, ((n1.getY()+n2.getY())/2)-2);
        }

    }



    public void setButtons(boolean b) {
        btn.setDisable(b);
        btn2.setDisable(b);
    }
}
