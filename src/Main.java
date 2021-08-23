public class Main {
    public static void main(String[] args) {
        int height=7;
        int width=7;
        char[][] maze = new char[][]{
                {'#','#', 'O', '#', '#', '#','#'},
                {'#','#', ' ', ' ', '#', ' ','#'},
                {'#',' ', '#', ' ', '#', ' ','#'},
                {'#','#', '#', ' ', ' ', ' ','#'},
                {'#','#', '#', '#', '#', ' ','#'},
                {'#','#', ' ', '#', ' ', ' ','#'},
                {'#','#', '#', '#', 'X', '#','#'} };
        int[][] mazevisited = new int[][]{
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0},
                {0,0, 0, 0, 0, 0,0} };
        System.out.println("Solution is:"+mazeSolve(maze,mazevisited,height,width));
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                System.out.print(mazevisited[i][j]);

            }
            System.out.println();
        }
    }
    public static String mazeSolve(char[][] maze, int[][] mazevisited,int height,int width){
        int startX=-1;
        int startY=-1;
        System.out.println("entered");
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(maze[i][j]=='O')
                {
                    startX=j;
                    startY=i;
                }
            }
        }
//        System.out.println(startX + ""+ startY);
        if(startX ==-1 || startY == -1)
        {
            System.out.println("No start Found.");
            return "No start found";
        }
        int currentX=startX;
        int currentY=startY;
        String path="";
        //System.out.println(path+"raj");
        mazevisited[currentY][currentX]+=1;
        while(maze[currentY][currentX]!='X') {
            if (currentY + 1 < height && maze[currentY + 1][currentX] != '#' && mazevisited[currentY+1][currentX]<=2) {
                path += 'D';
                mazevisited[currentY][currentX]+=1;
                currentY += 1;
            } else if (currentX + 1 < width && maze[currentY][currentX + 1] != '#' && mazevisited[currentY][currentX+1]<=2) {
                path += 'R';
                mazevisited[currentY][currentX]+=1;

                currentX += 1;
            } else if (currentX - 1 >= 0 && maze[currentY][currentX-1] != '#' && mazevisited[currentY][currentX-1]<=2) {
                path += 'L';
                mazevisited[currentY][currentX]+=1;

                currentX -= 1;
            } else if (currentY - 1 >= 0 && maze[currentY - 1][currentX] != '#' && mazevisited[currentY-1][currentX]<=2) {
                path += 'U';
                mazevisited[currentY][currentX]+=1;

                currentY -= 1;
            } else {
                return "No Solution";
            }
            System.out.println(path);
        }


//    System.out.println(path);
        return path;
    }
}
