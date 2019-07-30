// https://leetcode.com/problems/max-area-of-island/

package misc.arrays;

public class MaxAreaIsland{
  public int maxAreaOfIsland(int[][] grid){
    if(grid.length == 0) return 0;
    if(grid[0].length == 0) return 0;

    int max = 0;
    for(int i=0;i<grid.length;i++)
      for(int j=0;j<grid[0].length;j++)
        max = Math.max(max, area(grid, i, j));

    return max;
  }

  private int area(int[][] grid, int i, int j){
    if(i >= grid.length || i < 0) return 0;
    if(j >= grid[i].length || j < 0) return 0;
    if(grid[i][j] != 1) return 0;

    grid[i][j] = 0;
    
    return 1 + 
      area(grid, i+1, j) + area(grid, i-1, j) + area(grid, i, j+1) + area(grid, i, j-1);
  }
  public static void main(String[] args) {
    // int[][] input = { {0,1,0,0},
    //                   {1,1,1,0},
    //                   {0,0,0,1},
    //                   {1,1,1,1}};

    int[][] input = { {1,1,0,0,0},
                      {1,1,0,0,0},
                      {0,0,0,1,1},
                      {0,0,0,1,1}};

    System.out.println(new MaxAreaIsland().maxAreaOfIsland(input));

  }
}