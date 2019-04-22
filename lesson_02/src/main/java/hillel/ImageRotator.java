package hillel;

public class ImageRotator
{
  int[][] img = new int[][]
      {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9}
      };
int size = img.length;

  public int[][] rotate(int[][] img)
  {
    int [][] turnedImg= new int[size][size];
    for (int i = 0; i< size; i++)
    {
      for (int j = 0; j< size; j++) 
      {
        turnedImg[size -1-j][i]= img[i][j];
      }
    }
    img=turnedImg;
    return img;
  }
}

