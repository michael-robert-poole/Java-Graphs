package Main.Java.GUI;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Node {
    private Shape circle;
    private double x;
    private double y;
    private double radius;
    private String label;


    public Node(double x, double y, double radius, String label) {
        this.label = label;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(Pane pane, GraphicsContext gc){
        if (circle == null){
            circle = new Circle(x,y,radius, Color.GREEN);
            pane.getChildren().add(circle);
            writeText(gc);
        }
        else{
            circle.setFill(Color.GREEN);
        }
    }

    public void writeText(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.setFont(new Font(15));
        gc.fillText(label, x+5 , y+25);
    }

    public void update() {
        circle.setFill(Color.RED);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
