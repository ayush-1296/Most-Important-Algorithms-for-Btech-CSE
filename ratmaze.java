 public class ratmaze {

 int maze[][] = {{1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 9, 0, 1, 1},
            {1, 1, 1, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
 int mazelength = maze.length;
// This program considers RAT can move all four directions.
/* FIND-PATH(x, y)
if (x,y outside maze) return false
if (x,y is goal) return true
if (x,y not open) return false
mark x,y as part of solution path
if (FIND-PATH(North of x,y) == true) return true
if (FIND-PATH(East of x,y) == true) return true
if (FIND-PATH(South of x,y) == true) return true
if (FIND-PATH(West of x,y) == true) return true
unmark x,y as part of solution path
return false*/		
public boolean findPath(int x, int y){	
	// check x,y are outside maze.
	if(x < 0 || x >= mazelength || y < 0 || y >= mazelength ){
		return false;
	}
	if(maze[x][y] == 9) {
		return true;
	}
	if(maze[x][y] != 1) return false;
	
	//mark x, y as part of the solution path
	if(maze[x][y] == 1){
		maze[x][y] = 3;
	}
	// move North
	if( findPath(x-1,y)){
		return true;
	}
	//move East
	if( findPath(x,y+1)) return true;
	//move South
	if( findPath(x+1,y)) return true;
	//move West
	if( findPath(x,y-1)) return true;
	// unMark x,y as part of the solution.
	maze[x][y] = 0;
	
	return false;
	
}

public void printSolution(){
	System.out.println("Final Solution ::::::: ");
	
	for(int i=0;i<mazelength;i++){
		for(int j=0;j<mazelength;j++){
			System.out.print(" "+maze[i][j]+" ");
		}
		System.out.println();
	}
}

public static void main(String args[]){
	ratmaze  ratMazeProblem = new ratmaze();
	System.out.println(" Does Path exist ::: "+ratMazeProblem.findPath(0,0));
	ratMazeProblem.printSolution();
	
	 
}
}
