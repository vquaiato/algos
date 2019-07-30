package misc.arrays;

public class NumIslands {
  public int numIslands(String[][] grid) {
    int lines = grid.length;
    if(lines == 0) return 0;

    int columns = grid[0].length;
    if(columns == 0) return 0;

    int islands = 0;
    for(int i=0;i<lines;i++)
      for(int j=0;j<columns;j++)
        islands += visitIsland(grid, i, j);

    return islands;
  }
  private int visitIsland(String[][] grid, int i, int j){
    if(i >= grid.length || i < 0 ||
       j >= grid[0].length || j < 0 ||
       grid[i][j]!="1") return 0;

    grid[i][j] = "0";
    visitIsland(grid, i+1, j);
    visitIsland(grid, i-1, j);
    visitIsland(grid, i, j+1);
    visitIsland(grid, i, j-1);
    return 1;
  }

  public static void main(String[] args) {
    NumIslands n = new NumIslands();
    System.out.print(n.numIslands(new String[][]{{"1","0","1","1","1"},{"1","0","1","0","1"},{"1","1","1","0","1"}}));
  }
}