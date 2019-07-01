package shylov.ball;

public enum Direction
{

  NORTH(0),NE(1),EAST(2),SE(3),SOUTH(4),SW(5),WEST(6),NW(7);

  private int x;

  Direction(int x)
  {
    this.x = x;
  }
  public int getNumeric(){
    return x;
  }
}
