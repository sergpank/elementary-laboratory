public class ArrayRotation
{
  public static void main(String[] argv)
  {
    imageRotator(4);
  }

  public static void imageRotator(int matrixSize)
  {
    int m = matrixSize;

    int[][] A = new int[m][m];
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < m; j++)
      {
        A[i][j] = m * i + j;
      }
    }

    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < m; j++)
      {
        System.out.printf("%3d ", A[i][j]);
      }
      System.out.print("\n");
    }
    System.out.print("\nШАЗАМ:\n\n");

    for (int k = 0; k < m / 2; k++)
    {
      for (int j = k; j < m - 1 - k; j++)
      {

        int tmp = A[k][j];
        A[k][j] = A[j][m - 1 - k];
        A[j][m - 1 - k] = A[m - 1 - k][m - 1 - j];
        A[m - 1 - k][m - 1 - j] = A[m - 1 - j][k];
        A[m - 1 - j][k] = tmp;
      }
    }

    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < m; j++)
      {
        System.out.printf("%3d ", A[i][j]);
      }
      System.out.print("\n");
    }
  }
}