public class Pascal
{
  public int drawLevelCount = 0;
  public static void main(String[] args)
  {
    Pascal pascal = new Pascal();
    pascal.build(8,0);

  }
  public int build(int level, int number)
  {
    if (drawLevelCount < 1)
    {
      System.out.println(1);
      drawLevelCount++;        // костыль. был баг, если рисовать треугольник на более чем 1 уровень то вместо нулевого рисуетс два раза первый,
    }                           // не смог найти решение, по этому так

    int[] str = new int[level+1];
    str[0] = 1;  // заполнение
    if(level>0)
    {
      str[level] = 1;  // заполнение
    }
    for(int i = 1; i < level; i++)
    {
      str[i] = (build(level-1, i-1) + build(level - 1, i));   // заполнение
    }
    if(drawLevelCount <= level)          //
    {                                     //
      for (int i = 0; i <= level; i++)    //
      {                                     //   ОТРИСОВКА
        System.out.print(str[i] + " ");     //
      }                                       //
      System.out.println();                   //
      drawLevelCount++;                         //
    }                                           //
    return str[number];
  }
}

