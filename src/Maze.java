public class Maze {
    public static void main(String[] args) {
        int grid[][]={ {'#','#', 'O', '#', '#', '#','#'},
                {'#','#', ' ', ' ', '#', ' ','#'},
                {'#',' ', '#', ' ', '#', ' ','#'},
                {'#','#', '#', ' ', ' ', ' ','#'},
                {'#','#', '#', ' ', '#', ' ','#'},
                {'#','#', ' ', ' ', ' ', ' ','#'},
                {'#','#', '#', '#', 'X', '#','#'} };

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        solveMaze(grid,0,2,"",visited);
    }

    private static void solveMaze(int[][] grid, int row, int col, String ans, boolean[][] visited) {
        if (row == 6 && col == 4) {
            System.out.println(ans);
            return;
        }
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '#')
        {
            return;
        }
        visited[row][col]=true;
        solveMaze(grid, row-1, col,ans+"T",visited);
        //System.out.println(ans);
        solveMaze(grid, row+1, col,ans+"D",visited);
        //System.out.println(ans);
        solveMaze(grid, row, col-1,ans+"L",visited);
        //System.out.println(ans);
        solveMaze(grid, row, col+1,ans+"R",visited);
        //System.out.println(ans);
        visited[row][col]=false;
    }
}
