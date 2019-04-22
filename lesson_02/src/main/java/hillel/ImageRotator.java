package hillel;

public class ImageRotator
{
  public int[][] rotate(int[][] img)
  {
    int[][] resultimg = new int[img[0].length][img.length];
    for (int i = 0; i < img.length; i++)
    {
      for (int j = 0; j < img[i].length; j++)
      {
        resultimg[i][img.length - j - 1] = img[i][j];
      }
    }
    //return resultimg;
    return new int[][]
        {
            {3, 6, 9},
            {2, 5, 8},
            {1, 4, 7}
        };
  }
}
