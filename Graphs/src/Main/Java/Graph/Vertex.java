package Main.Java.Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    T label;
    List<Edge> neighbours;

    public Vertex(T label) {

        this.label = label;
        neighbours = new ArrayList<Edge>();

    }


}
