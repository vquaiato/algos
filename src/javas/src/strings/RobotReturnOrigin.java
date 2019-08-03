// https://leetcode.com/problems/robot-return-to-origin/

package strings;

public class RobotReturnOrigin {
  public boolean judgeCircle(String moves) {
    if (moves == null || moves.isEmpty())
      return true;

    int x = 0, y = 0;
    for (char c : moves.toCharArray()) {
      switch (c) {
      case 'U':
        y++;
        break;
      case 'R':
        x++;
        break;
      case 'D':
        y--;
        break;
      default:
        x--;
      }
    }

    return x == 0 && y == 0;
  }

  public static void main(String[] args) {
    String input = "UD";
    // String input = "LL";
    System.out.println(new RobotReturnOrigin().judgeCircle(input));
  }
}