package assignment07;

import java.util.ArrayList;

public class Node
{
    Character value ;
    //int xCoordinate ;
    //int yCoordinate ;
    ArrayList<Node> neighbors ;

    boolean isVisited ;

    boolean path ;

    Node cameFrom ;

    public Node (Character value)
    {
        this.value = value ;
        //this.xCoordinate = -1;
        //this.yCoordinate = -1 ;
        isVisited = false ;
        path = false ;
        this.neighbors = new ArrayList<>() ;

    }
}
