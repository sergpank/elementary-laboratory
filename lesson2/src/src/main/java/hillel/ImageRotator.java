package hillel;

public class ImageRotator
{

  int[][] rotate(int[][] img)
  {
    int[][] turnedImg = new int[img.length][img.length];
    for (int i = 0; i < img.length; ++i)
    {
      for (int j = 0; j < img.length; ++j)
      {
        turnedImg[img.length - 1 - j][i] = img[i][j];
      }
    }
    return turnedImg;
  }
}