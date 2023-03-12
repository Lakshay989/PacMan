package assignment07;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder
{
    static int height ; // Height of the Maze
    static int width ; // Width of the maze

    static Node maze[][] ; // Representing the Maze using a 2D Array

    static Node start ; // Start Node in the Maze (S)
    static Node end ; // End Node in the Array (G)

    static boolean pathExists;

    static Queue<Node> bfsQueue = new LinkedList<>(); //  BFS - Use LinkedList implemented using Queue

    static int countSteps = 0 ;

    public static void solveMaze(String inputFile, String outputFile) throws IOException // full path to files we want to read/write in our tests. See required specifications below.
    {
        // This function is the driver method and has all the required function calls for the assignment

        FileReader input = new FileReader(inputFile) ; // To read the file
        BufferedReader readFile = new BufferedReader(input) ; // file as a stream  // Can use scanner?

        String[] dimensions = readFile.readLine().split(" ");  // Getting the Height and Width of the Maze
        height = Integer.parseInt(dimensions[0]);
        width = Integer.parseInt(dimensions[1]);

        maze = new Node[height][width] ; // Initializing the maze

        Character temp ;

        for (int i = 0 ; i<height; i++)
        {
            for(int j = 0 ; j<width ; j++)
            {
                maze[i][j] =new Node ((char) readFile.read()) ; // Filling the maze with Nodes
            }
//            temp = (char)
              readFile.read() ; // To take care of the escape sequence at the end
        }

        //printMaze();  // Can  uncomment for viewing the maze
        System.out.print("\n");

        setNeighbors();
        setStartEnd(maze);

        BFS(start,end);

        printMaze(); //  Can  uncomment for viewing the maze

        try (PrintWriter output = new PrintWriter(new FileWriter(outputFile))) { // try-resource block for writing to the file

            output.println(height + " " + width);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++)
                {
                    output.print(maze[i][j].value);
                }
                output.print("\n");
            }
            //output.close(); // Redundant call
        }

    }
    public static void setNeighbors() // This function sets the neighbors of each node if it is not a wall
    {
        for (int i = 0 ; i<height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j].value != 'X') {
                    if (maze[i - 1][j].value == ' ' || maze[i - 1][j].value == 'S' || maze[i - 1][j].value == 'G')//Left Neighbor
                    {
                        maze[i][j].neighbors.add(maze[i - 1][j]);
                    }

                    if (maze[i + 1][j].value == ' ' || maze[i + 1][j].value == 'S' || maze[i + 1][j].value == 'G')//Right Neighbor
                    {
                        maze[i][j].neighbors.add(maze[i + 1][j]);
                    }

                    if (maze[i][j + 1].value == ' ' || maze[i][j + 1].value == 'S' || maze[i][j + 1].value == 'G')// Bottom Neighbor
                    {
                        maze[i][j].neighbors.add(maze[i][j + 1]);
                    }

                    if (maze[i][j - 1].value == ' ' || maze[i][j - 1].value == 'S' || maze[i][j - 1].value == 'G')// Top Neighbor
                    {
                        maze[i][j].neighbors.add(maze[i][j - 1]);
                    }
                }
            }
        }
    }

    public static void setStartEnd(Node maze[][]) // Sets the Start and the End nodes
    {
        for (int i = 0 ; i<height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j].value == 'S') {
                    start = maze[i][j];
                }

                if (maze[i][j].value == 'G') {
                    end = maze[i][j];
                }
            }
        }
    }


    public static void BFS(Node start, Node end) {  // Performs a Breadth First Search throughout the maze and also backtracks the path

        start.isVisited = true ;
        bfsQueue.add(start) ;

        while (!bfsQueue.isEmpty())
        {
            Node n = bfsQueue.remove() ;
            if(n.value == 'G') { // or if(n.equals(end))
                Node backtrack = n.cameFrom ;
                while(backtrack.value != 'S')    //following cameFrom links back to start
                {
                    //backtrack.path = true ;
                    backtrack.value = '.';
                    backtrack = backtrack.cameFrom ;
                }
                pathExists = true ; // To check in the case of more than 1 'G' present maybe
            }

            if(! pathExists)
            {
                for (int i = 0; i < n.neighbors.size(); i++)  // Iterating through the neighbors of the node
                {
                    Node neighbor = n.neighbors.get(i);
                    if (!neighbor.isVisited && neighbor.value != 'X') {
                        neighbor.isVisited = true;
                        neighbor.cameFrom = n;
                        bfsQueue.add(neighbor);
                    }
                }
            }
            pathExists = false ;
        }
    }

    public static void printMaze() // Helper to print the MAZE
    {
        System.out.println(height + " " + width);
        for (int i = 0 ; i<height; i++)
        {
            for(int j = 0 ; j<width ; j++)
            {
                System.out.print(maze[i][j].value);
                if(maze[i][j].value == '.')
                {
                    countSteps++ ;
                }
            }
            System.out.print("\n");
        }
    }

    public static int countSteps(String inputFile) throws IOException  // Helper Functions for Testing
    {
        FileReader input = new FileReader(inputFile) ; // To read the file
        BufferedReader readFile = new BufferedReader(input) ; // file as a stream  // Can use scanner?

        String[] dimensions = readFile.readLine().split(" ");  // Getting the Height and Width of the Maze
        height = Integer.parseInt(dimensions[0]);
        width = Integer.parseInt(dimensions[1]);

        //maze = new Node[height][width] ; // Initializing the maze

        int count = 0;

        for (int i = 0 ; i<height; i++)
        {
            for(int j = 0 ; j<width ; j++)
            {
                if (maze[i][j].value == '.')
                {
                    count++ ;
                }
            }
            readFile.read() ; // To take care of the escape sequence at the end
        }
        return count ;
    }
}

