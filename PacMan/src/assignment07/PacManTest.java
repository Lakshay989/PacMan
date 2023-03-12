package assignment07;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PacManTest {

    String filename ;
    String solFile ;

    String filename1 ;
    String solFile1 ;

    @org.junit.jupiter.api.Test
    void solveMaze() throws IOException {

        filename1 = "tinyMazeOutput.txt" ;
        solFile1 = "tinyMazeSol.txt" ;
        PathFinder.solveMaze("tinyMaze.txt", filename1);
        System.out.println(PathFinder.countSteps(filename1));
        System.out.println(PathFinder.countSteps(solFile1));
        assertTrue(PathFinder.countSteps(filename1) == PathFinder.countSteps(solFile1) );

        filename1 = "randomMazeOutput.txt" ;
        solFile1 = "randomMazeSol.txt" ;
        PathFinder.solveMaze("randomMaze.txt", filename1);
        System.out.println(PathFinder.countSteps(filename1));
        System.out.println(PathFinder.countSteps(solFile1));
        assertTrue(PathFinder.countSteps(filename1) == PathFinder.countSteps(solFile1) );

        filename = "bigMazeOutput.txt" ;
        solFile = "bigMazeSol.txt" ;
        PathFinder.solveMaze("bigMaze.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );

        filename = "unsolvableOutput.txt" ;
        solFile = "unsolvableSol.txt" ;
        PathFinder.solveMaze("unsolvable.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );


        filename = "classicOutput.txt" ;
        solFile = "classicSol.txt" ;
        PathFinder.solveMaze("classic.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );


        filename = "demoMazeOutput.txt" ;
        solFile = "demoMazeSol.txt" ;
        PathFinder.solveMaze("demoMaze.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );

        filename = "mediumMazeOutput.txt" ;
        solFile = "mediumMazeSol.txt" ;
        PathFinder.solveMaze("mediumMaze.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );

        filename = "straightOutput.txt" ;
        solFile = "straightSol.txt" ;
        PathFinder.solveMaze("straight.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );

        filename = "tinyOpenOutput.txt" ;
        solFile = "tinyOpenSol.txt" ;
        PathFinder.solveMaze("tinyOpen.txt", filename);
        System.out.println(PathFinder.countSteps(filename));
        System.out.println(PathFinder.countSteps(solFile));
        assertTrue(PathFinder.countSteps(filename) == PathFinder.countSteps(solFile) );

    }
}