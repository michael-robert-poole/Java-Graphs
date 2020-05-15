package Main.Java.Graph;

import java.util.*;

public class Graph {
    private Map<String, Vertex> vertices;

    public Graph() {
        this.vertices = new Hashtable<>();
    }

    public void addVertex(String label){
        vertices.putIfAbsent(label, new Vertex(label));
    }



    //Add code to remove vertices

    public void addEdge(String label, String label2, int cost){
        Vertex v1 = vertices.get(label);
        Vertex v2 = vertices.get(label2);
        v1.neighbours.add(new Edge(v2, cost));
        v2.neighbours.add(new Edge(v1, cost));

    }

    //Add code to remove edges




    public List<Vertex> getAdjVertices(String label) {
        Vertex v1 = vertices.get(label);
        List<Vertex> adjVertices = new ArrayList<>();
        for ( Object e: v1.neighbours){
            Edge a = (Edge) e;
            adjVertices.add(a.getVertex());
        }
        return adjVertices;
    }



    public List<String> depthFirstTraversal(String root) {
        List<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack<String>();
        if (!vertices.containsKey(root)) {
            root = vertices.keySet().toArray()[0].toString();
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : getAdjVertices(vertex)) {
                    stack.push(v.label.toString());
                }
            }
        }
        return visited;
    }

    public List<String> breadthFirstTraversal(String root) {
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<String>();
        if (!vertices.containsKey(root)) {
            root = vertices.keySet().toArray()[0].toString();
        }
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label.toString());
                    queue.add(v.label.toString());
                }
            }
        }
        return visited;
    }


}
