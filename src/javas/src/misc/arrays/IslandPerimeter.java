// https://leetcode.com/problems/island-perimeter/

package misc.arrays;

public class IslandPerimeter{
  public int islandPerimeter(int[][] grid) {
    return count(grid, 0, 0);    
  }
  private int count(int[][] mapa, int i, int j){
    int linhas = mapa.length;
    if(i >= linhas || i < 0) return 0;
    int colunas = mapa[i].length;
    if(j >= colunas || j < 0) return 0;

    int pos = mapa[i][j];
    if(pos == -1 || pos == 2) return 0;

    int counter = 0;
    if(pos == 1){
      if(i+1 >= linhas || mapa[i+1][j] <= 0) counter++;
      if(i-1 < 0 || mapa[i-1][j] <= 0) counter++;
      if(j+1 >= colunas || mapa[i][j+1] <= 0) counter++;
      if(j-1 < 0 || mapa[i][j-1] <= 0) counter++;
    }

    mapa[i][j] = mapa[i][j] == 1 ? 2 : -1;

    return counter + 
            count(mapa, i+1, j)+
            count(mapa, i-1, j)+
            count(mapa, i, j+1)+
            count(mapa, i, j-1);
  }

  public static void main(String[] args) {
    // int[][] input = { {0,1,0,0},
    //                   {1,1,1,0},
    //                   {0,1,0,0},
    //                   {1,1,0,0}};

    int[][] input = { {0,0},
                      {1,0}};
    System.out.println(new IslandPerimeter().islandPerimeter(input));
  }
}