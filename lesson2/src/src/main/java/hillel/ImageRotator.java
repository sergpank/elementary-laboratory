package hillel;

public class ImageRotator
{
  public static void main(String[] args)
  {
    int[][] img = new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
  }

  public static int[][] rotate(int[][] img)
  {
    int[][] turned = new int[img.length][img.length];
    for (int i = 0; i < img.length; i++)
    {
      for (int j = 0; j < img.length; j++)
      {
        img[i][j] = img.length - 1 - i;
      }
    }
    for (int i = 0; i < (img).length; i++)
    {
      for (int j = 0; j < (img).length; j++)
      {
        System.out.print((img)[i][j]);
      }
      System.out.println();
    }
    return turned;
  }
}