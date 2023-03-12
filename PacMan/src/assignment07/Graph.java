package assignment07;

import java.util.ArrayList;

public class Graph
{
    ArrayList<Node> graph = new ArrayList<>() ;
    int graphHeight ;
    int graphWidth ;

    public Graph(ArrayList<Node> graph, int height, int width)
    {
        this.graph       = graph ;
        this.graphHeight = height;
        this.graphWidth  = width ;
    }
}
