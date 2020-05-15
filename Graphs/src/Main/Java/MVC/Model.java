package Main.Java.MVC;

import Main.Java.Graph.Graph;

import java.util.List;

public class Model {
    private Graph graph;
    public Controller controller;
    public String search = "BSF";


    public Model() {

    }

    public void addVertex(String label) {
        graph.addVertex(label);
        controller.draw(label);
    }

    public void addEdge(String label1, String label2) {
        graph.addEdge(label1, label2,0);
        controller.drawEdge(label1,label2,0);
    }
    public void addEdge(String label1, String label2, int cost) {
        if (search.equals("BSF")){
            addEdge(label1, label2);
        }
        else{
            graph.addEdge(label1, label2,cost);
            controller.drawEdge(label1,label2,cost);
        }

    }

    public synchronized   void depthFirstTraversal(String label)  {

            List<String> nodes = graph.depthFirstTraversal(label);
            Thread thread = new Thread(new aThread(nodes, controller));
            thread.start();

    }

    public synchronized void breadthFirstTraversal(String label) {
        List<String> nodes = graph.breadthFirstTraversal(label);
        Thread thread = new Thread(new aThread(nodes, controller));
        thread.start();
    }

    public void getGraph() {
        graph = new Graph();
        addVertex("Bob");
        addVertex("Alice");

        addVertex("Rob");
        addVertex("Maria");
        addVertex("Mike");
        addVertex("Mel");
        addVertex("Tim");
        addVertex("Mark");
        addEdge("Bob", "Alice",3);
        addEdge("Bob", "Rob",5);
        //addEdge("Bob", "Mark",2);
        //addEdge("Rob", "Mark",1);
        //addEdge("Alice", "Maria",8);
        addEdge("Tim", "Maria",10);
        //addEdge("Rob", "Mel",10);
       // addEdge("Mike", "Maria",15);
       // addEdge("Maria", "Mel",3);
        //addEdge("Mike", "Mel",6);
        addEdge("Bob", "Maria");
        addEdge("Mike", "Tim");
        addEdge("Mark", "Tim");
        addEdge("Mark", "Mel");

    }
}

class aThread implements Runnable{
    List <String> ls;
    Controller cntrl;

    public aThread(List<String> ls, Controller cntrl) {
        this.ls = ls;
        this.cntrl = cntrl;
    }


    @Override
    public void run() {
        int i = 0;
        for (String n:ls){
            cntrl.updateColor(n, i++);
            System.out.println(n);

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("I ahve been Interrupted");
                e.printStackTrace();
            }
        }


        System.out.println("End Thread");
        cntrl.showButtons();
    }
}