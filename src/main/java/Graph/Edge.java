package main.java.Graph;

public class Edge {
    private Vertex vertex;
    private int cost;

    public Edge(Vertex vertex, int cost) {
        this.vertex = vertex;
        if (cost < 0 ){
            this.cost = 1;
        }
        else{
            this.cost = cost;
        }
    }

    public Vertex getVertex() {
        return vertex;
    }

    public int getCost() {
        return cost;
    }
}
